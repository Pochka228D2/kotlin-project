package monkey

import java.io.File

interface Sellable{
    val price: Double
    fun sellItem()
}

class Bananaclass(
    val id:Int,
    override val price: Double): Sellable{
    override fun sellItem(){
        println("банан $id продан по цене $price")
    }
}

class Store {
    val items = mutableListOf<Sellable>()

    init {
        addItem(ClassMonkey(1, "Чиичи", 5, Rarity.Rare))
        addItem(ClassMonkey(2, "Люба", 1, Rarity.Legendary))
        addItem(ClassMonkey(3, "Кики", 99, Rarity.Common))

        addItem(Bananaclass(1,20.0))
        addItem(Bananaclass(2,50.0))
        addItem(Bananaclass(3,99.9))

        loadFromFile()
    }

    fun addItem(item: Sellable) {
        if (item is ClassMonkey) {
            val existingMonkey = items.find { existingItem ->
                existingItem is ClassMonkey && existingItem.id == item.id
            }

            if (existingMonkey != null) {
                println("!!!!этот id уже существует.давай по новой!!!!")
                return
            }
        }
        items.add(item)
    }

    fun sellAllItems() {
        items.forEach { item ->
            item.sellItem()
        }
    }

    fun showItems() {
        val monkeys = items.filterIsInstance<ClassMonkey>().sortedBy { it.id }
        val bananas = items.filterIsInstance<Bananaclass>().sortedBy { it.id }

        println("=== БИБИЗЯНЫ ===")
        monkeys.forEach { monkey ->
            println("Обезьяна:ID ${monkey.id} - ${monkey.name} - Цена: ${monkey.price}")
        }

        println("=== БАНАНЫ ЧТО БЫ КОРМИТЬ БИБИЗЯН ===")
        bananas.forEach { banana ->
            println("Банан:ID ${banana.id} - Цена: ${banana.price}")
        }
    }

    fun saveToFile() {
        try {
            File("market.txt").printWriter().use { writer ->
                items.forEach { item ->
                    when (item) {
                        is ClassMonkey -> writer.println("бибизяна,${item.id},${item.name},${item.age},${item.rarity},${item.isSold}")
                        is Bananaclass -> writer.println("банан,${item.id},${item.price}")
                    }
                }
            }
            println("Рынок бибизян сохранен в файл!")
        } catch (e: Exception) {
            println("Ошибка сохранения: ${e.message}")
        }
    }

    fun loadFromFile() {
        val file = File("market.txt")
        if (!file.exists()) {
            println("Файл сохранения не найден. Генерирую старых мартышек")
            return
        }

        try {
            val loadedItems = mutableListOf<Sellable>()

            file.forEachLine { line ->
                val parts = line.split(",")
                when (parts[0]) {
                    "бибизяна" -> {
                        val monkey = ClassMonkey(
                            id = parts[1].toInt(),
                            name = parts[2],
                            age = parts[3].toInt(),
                            rarity = Rarity.valueOf(parts[4]),
                            isSold = parts[5].toBoolean()
                        )
                        loadedItems.add(monkey)
                    }
                    "банан" -> {
                        val banana = Bananaclass(
                            id = parts[1].toInt(),
                            price = parts[2].toDouble()
                        )
                        loadedItems.add(banana)
                    }
                }
            }

            items.clear()
            items.addAll(loadedItems)
            println("Рынок бибизян загружен из файла!")
        } catch (e: Exception) {
            println("Ошибка загрузки: ${e.message}")
        }
    }

    fun removeItemById(id: Int) {
        val itemToRemove = items.find { item ->
            (item is ClassMonkey && item.id == id) || (item is Bananaclass && item.id == id)
        }

        if (itemToRemove != null) {
            items.remove(itemToRemove)
            println("Товар с ID $id удален!")
        } else {
            println("Товар с ID $id не найден")
        }
    }

    fun sellMonkeyById(id: Int, user: User? = null) {
        val monkey = items.find { item ->
            item is ClassMonkey && item.id == id
        } as? ClassMonkey

        if (monkey != null) {
            monkey.sell()
            items.remove(monkey)

            // Определяем тип для бонуса
            val type = when (monkey) {
                is RobotMonkey -> "робот"
                is MagicMonkey -> "магическая"
                else -> "обычная"
            }


            user?.sellMonkeyWithTax(monkey, type)


            if (user == null) {
                println("+${monkey.price} монет!")
                println("Бибизяна '${monkey.name}' (ID: $id) продана!")
            }
        } else {
            println("Бибизяна с ID $id не найдена")
        }
    }

    fun sellBananaById(id: Int, user: User? = null) {
        val banana = items.find { item ->
            item is Bananaclass && item.id == id
        } as? Bananaclass

        if (banana != null) {
            banana.sellItem()
            items.remove(banana)
            user?.balanse = user?.balanse?.plus(banana.price) ?: 0.0
            println("+${banana.price} монет!")
            println("Банан (ID: $id) продан и удален из списка!")
            println("Новый баланс: ${user?.balanse} монет")
        } else {
            println("Банан с ID $id не найден")
        }
    }
}
package monkey

class User {
    var balanse: Double = 50.0
    val cart = mutableListOf<Sellable>()

    fun createCommonMonkey(): Boolean {
        val cost = 10.0
        if (balanse >= cost) {
            balanse -= cost
            println(" Создана обычная бибизяна за $cost монет")
            println(" Баланс: $balanse монет")
            return true
        } else {
            println(" Недостаточно денег! Нужно $cost монет, есть $balanse")
            return false
        }
    }

    fun createEpicMonkey(): Boolean {
        val cost = 15.0  // ← ИСПРАВИЛ ЦЕНУ
        if (balanse >= cost) {
            balanse -= cost
            println(" Создана эпическая бибизяна за $cost монет")  // ← ИСПРАВИЛ ТЕКСТ
            println(" Баланс: $balanse монет")
            return true
        } else {
            println(" Недостаточно денег! Нужно $cost монет, есть $balanse")
            return false
        }
    }

    fun createLegendaryMonkey(): Boolean {
        val cost = 50.0  // ← ИСПРАВИЛ ЦЕНУ
        if (balanse >= cost) {
            balanse -= cost
            println(" Создана легендарная бибизяна за $cost монет")  // ← ИСПРАВИЛ ТЕКСТ
            println(" Баланс: $balanse монет")
            return true
        } else {
            println(" Недостаточно денег! Нужно $cost монет, есть $balanse")
            return false
        }
    }

    fun sellMonkeyWithTax(monkey: ClassMonkey, type: String) {  // ← ИСПРАВИЛ ПАРАМЕТР
        val tax = 5.0
        var bonus = 0.0

        when (type) {
            "робот" -> bonus = 50.0
            "магическая" -> bonus = 50.0
        }

        val totalIncome = monkey.price + bonus - tax  // ← ИСПРАВИЛ monkey

        balanse += totalIncome
        println("Продажа бибизяны:")
        println("Цена: ${monkey.price} монет")  // ← ИСПРАВИЛ monkey
        println("Бонус за тип: +$bonus монет")
        println("Налог: -$tax монет")
        println("Итого: +$totalIncome монet")
        println("Новый баланс: $balanse монет")
    }

    fun addtocart(item: Sellable) {
        cart.add(item)
        println("${getItemName(item)} добавлен в корзиночку")
    }

    fun buycart(): Boolean {
        val total = cart.sumOf { it.price }
        if (balanse >= total) {
            balanse -= total
            println(" покупка совершена! списано $total, баланс $balanse")
            cart.clear()
            return true
        } else {
            println(" недостаточно деняг на бибизян(((")
            println(" нужно $total, есть $balanse")
            return false
        }
    }

    fun showCart() {
        println("~~~Корзинка~~~")
        if (cart.isEmpty()) {
            println("корзина пуста(((бибизянам грустно")
        } else {
            cart.forEach { item ->
                println("- ${getItemName(item)}: ${item.price} монет")
            }
            println("Итого: ${cart.sumOf { it.price }} монет")
        }
        println("Баланс: $balanse монет")
    }

    private fun getItemName(item: Sellable): String {
        return when(item) {
            is ClassMonkey -> "Бибизяна '${item.name}'"
            is Bananaclass -> "Банан ID:${item.id}"
            else -> "Товар"
        }
    }
}
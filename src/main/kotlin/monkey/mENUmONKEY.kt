import monkey.Store
import monkey.createNewMonkey
import monkey.createNewBanana
import monkey.User
import monkey.ClassMonkey
import monkey.Bananaclass

fun readSafeInt():Int {
    while(true){
        try{
           return readln().toInt()
        } catch (e: Exception){
            println("неверный ввод.введи число(или бибизяны покусают)")
        }
    }
}
fun readSafeDouble(): Double {
    while(true){
        try{
            return readln().toDouble()
        } catch (e: Exception){
            println("неверный ввод.введи число с плавающей точкой")
        }
    }
}

fun menu(store: Store) {
    val user = User()

    while(true){
        println("---==Добро пожаловать в наш магазин бибизян==!---")
        println("~~~ Баланс: ${user.balanse} монет")
        store.showItems()
        println("~1 - Добавить новую мартышку")
        println("~2 - Показать всех доступных мартышек и бананы")
        println("~3 - Продать товар по ID")
        println("~4 - Сохранить рынок")
        println("~5 - Добавить новый банан")
        println("~6 - Посмотреть корзиночку")
        println("~7 - Купить товары в корзиночке")
        println("~8 - Добавить товар в корзиночку")
        println("~exit - Выйти")

        val kok = readln()
        when(kok){
            "1" -> createNewMonkey(store, user )
            "2" -> store.showItems()
            "3" -> {
                println("Что продаем? (1) - бибизяну, (2) - банан)")
                val choice = readSafeInt()
                when (choice) {
                    1 -> {
                        println("введите ID бибизяны")
                        val id = readln().toInt()
                        store.sellMonkeyById(id, user)
                    }
                    2 -> {
                        println("введите ID банана")
                        val id = readln().toInt()
                        store.sellBananaById(id, user)
                    }
                    else -> println("Неверный ввод")
                }
            }
            "4" -> store.saveToFile()
            "5" -> createNewBanana(store)
            "6" -> user.showCart()
            "7" -> user.buycart()
            "8" -> {
                println("Что добавляем в корзиночку? (1 - бибизяну, 2 - банан)")
                val choice = readSafeInt()
                when (choice) {
                    1 -> {
                        println("введите ID бибизяны")
                        val id = readSafeInt()
                        val monkey = store.items.find { item ->
                            item is ClassMonkey && item.id == id
                        }
                        if (monkey != null) {
                            user.addtocart(monkey)
                        } else {
                            println(" Бибизяна не найдена")
                        }
                    }
                    2 -> {
                        println("введите ID банана")
                        val id = readSafeInt()
                        val banana = store.items.find { it is Bananaclass && it.id == id }
                        if (banana != null) {
                            user.addtocart(banana)
                        } else {
                            println(" Банан не найден")
                        }
                    }
                    else -> println("Неверный выбор")
                }
            }
            "exit" -> {
                println("гудбай")
                break
            }
            else -> println("Неизвестная команда, попробуйте снова")
        }
        println()
    }
}

fun main() {
    val store = Store()
    menu(store)
}
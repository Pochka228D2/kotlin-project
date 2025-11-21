import monkey.Store
import monkey.createNewMonkey


fun menu(store: Store) {
    while(true){
        println("---Добро пожаловать в наш киоск!---" )
        store.showItems()
        println("1 - Добавить новую мартышку")
        println("2 - Показать всех доступных мартышек и бананы")
        println("3 - Продать мартышку по ID")
        println("exit - Выйти")
        val kok = readln()
        when(kok){
            "1"-> createNewMonkey(store)
            "2"-> store.showItems()
            "3"-> store.sellAllItems()
            "exit" -> {
                println("гудбай")
                break
            }
            else -> println("Неизвестная команда, попробуйте снова")
        }
        println()

    }



}
fun main(){
    val store= Store()
    menu(store)

}
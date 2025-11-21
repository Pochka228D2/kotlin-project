package monkey
//Конструктор: Должен принимать id, name, age и rarity для создания новой мартышки.
//Методы (methods):
//getInfo(): возвращает строку с полным описанием мартышки (например, "ID: 1, Имя: Чико, Возраст: 5, Редкость: Rare, Статус: в продаже").
//sell(): меняет статус isSold на true.
fun main() {
    methods()
}
//каталог мартых и предложение о переписывание мартых
fun methods() {
    val store = Store()

    println("---ТЕКУЩИЙ КАТАЛОГ--- :")
    store.showItems()

    println("~~~продай все товары:")
    store.sellAllItems()


    println("~~~хочешь создать другую бибизяну?")
    createNewMonkey(store)
}
//содаем новую мортышку
fun createNewMonkey(store: Store){
    println("создай бибизяну!!!!:")

    println("введи Id")
    val id = readln().toInt()

    println("введи name")
    val name = readln()

    println("введи age")
    val age = readln().toInt()

    //редкость мортышекк
    println("выбери редкость (1 - Common, 2 - Rare, 3 - Legendary): ")
    val rarityC = readln().toInt()
    val rarity= when(rarityC){
        1 -> Rarity.Common
        2 -> Rarity.Rare
        3 -> Rarity.Legendary
        else ->Rarity.Common
    }

    //хотите добавить свойство мортышки?
    println("~~~хотите добавить свойство мортышки?? (1 - Obychnaya, 2 - Robot, 3 - Magicheskaya): ")
    val typeChoice = readln().toInt()
    val newMonkey = when(typeChoice ){
        2->{
            print("введите способность:")
            val chipVers=readln()
            RobotMonkey(id,name,age,rarity,chipVers)
        }
        3->{
            println("введите количество маны:")
            val manaPooll=readln().toInt()
            MagicMonkey(id,name,age,rarity,manaPooll)
        }
        else -> ClassMonkey(id, name, age, rarity)
    }


    //выводим мортышку
    println("бибизяна сделана!!!!!:")
    println(newMonkey.youMonkey())
    //хотите добавить свойство мортышки?


    //продать или нет
    print("хош продать бибизяну???:((((да или нет) ")
    val answer = readln()
    if (answer.equals("да", ignoreCase = true)) {
        newMonkey.sell()
    }

    // добавляем мартышку в список к другим мортышкам
    store.addItem(newMonkey)
    println("бибизяна добавлена к товарам")

    println("~~~~~~новый список товаров:")
    store.showItems()
}
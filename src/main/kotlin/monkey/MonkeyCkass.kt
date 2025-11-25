package monkey

import readSafeInt
import readSafeDouble


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
    val user = User()

    println("---ТЕКУЩИЙ КАТАЛОГ--- :")
    store.showItems()

    println("~~~продай все товары:")
    store.sellAllItems()


    println("~~~хочешь создать другую бибизяну?")
    createNewMonkey(store, user)
}
//содаем новую мортышку
fun createNewMonkey(store: Store,user: User){
    println("создай бибизяну!!!!:")
    println("Выбери тип бибизяны:")
    println("1 - Обычная (10 монет)")
    println("2 - Эпическая (15 монет)")
    println("3 - Легендарная (50 монет)")

    val typechoice=readSafeInt()
    var creationSuccess = false
    var monkeyType = ""

    when(typechoice){
        1->{
            creationSuccess=user.createCommonMonkey()
            monkeyType="обычная"
        }
        2->{
            creationSuccess=user.createEpicMonkey()
            monkeyType="эпическая"
        }
        3->{
            creationSuccess=user.createLegendaryMonkey()
            monkeyType="легендарная"
        }else -> {
            println("неверный ввод")
        return
        }
    }
    if(!creationSuccess){
        return
    }

    println("введи Id")
    val id = readSafeInt()

    println("введи name")
    val name = readln()

    println("введи age")
    val age = readSafeInt()

    //редкость мортышекк
    println("выбери редкость (1 - Common, 2 - Rare, 3 - Legendary): ")
    val rarityC =readSafeInt()
    val rarity= when(rarityC){
        1 -> Rarity.Common
        2 -> Rarity.Rare
        3 -> Rarity.Legendary
        else ->Rarity.Common
    }

    //хотите добавить свойство мортышки?
    println("~~~хотите добавить свойство мортышки?? (1 - Obychnaya, 2 - Robot, 3 - Magicheskaya): ")
    val typeChoice = readSafeInt()
    val newMonkey = when(typeChoice ){
        2->{
            print("введите способность:")
            val chipVers=readln()
            RobotMonkey(id,name,age,rarity,chipVers)
        }
        3->{
            println("введите количество маны:")
            val manaPooll=readSafeInt()
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
        user.sellMonkeyWithTax(newMonkey, monkeyType)
    } else {
        // если не продаем, просто добавляем в магазин
        store.addItem(newMonkey)
        if(store.items.contains(newMonkey)){
            println()
            println("---бибизяна добавлена к товарам---")
        } else {
            println("бибизяна НЕ добавлена к товарам")
        }
    }

    // добавляем мартышку в список к другим мортышкам
    store.addItem(newMonkey)
    if(store.items.contains(newMonkey)){
        println()
    println("---бибизяна добавлена к товарам---")}
    else {
        println("бибизяна НЕ добавлена к товарам")
    }
    println("~~~~~~новый список товаров:")
    store.showItems()
}
fun createNewBanana(store: Store){
println("---Создай бананчик для бибизяны!!!")
    println("введи Id")
    val id = readSafeInt()
    println("введи цену банана")
    val price = readSafeDouble()

    val newBanana = Bananaclass(id, price)

    store.addItem(newBanana)
    if (newBanana in store.items){
        print("бананчик создан!!!")
        println("ID: $id, Цена: $price")
        println("банан добавлен к товарам")
    } else{println("такой бананчик уже есть !!! ")}
}

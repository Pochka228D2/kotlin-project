package monkey

enum class Rarity {
    Common,
    Rare,
    Legendary
}
//добавляем опен что бы мы могли вернуться к функции и классу
open class ClassMonkey (
    val id:Int,
    val name: String,
    val age: Int,
    val rarity: Rarity,
    var isSold: Boolean=false):Sellable
//реализуем цену бананов к биибизянам
{
    override val price: Double
    get() = when (rarity){
        Rarity.Common -> 12.7
        Rarity.Rare -> 30.0
        Rarity.Legendary -> 99.9
    }

    override fun sellItem() {
        sell()
    }


 open fun youMonkey(): String {
        val status = if (isSold) "продана" else "не продана"
        return "ID:$id, имя:$name, возраст:$age, редкость:$rarity, статус:$status"

}
    // Метод ВНУТРИ класса
    fun sell() {
        isSold = true
        println("бибизяна  $name продана")
    }
}
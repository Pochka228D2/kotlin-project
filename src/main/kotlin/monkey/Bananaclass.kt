package monkey

interface Sellable{
    val price: Double
    fun sellItem()
}

class Bananaclass(override val price: Double): Sellable{
    override fun sellItem(){
        println("бананы проданы по цене $price")
    }

}
class Store{
    val items = mutableListOf<Sellable>()

    init {
        addItem(ClassMonkey(1, "Чиичи", 5, Rarity.Rare))
        addItem(ClassMonkey(2, "Люба", 1, Rarity.Legendary))
        addItem(ClassMonkey(3, "Кики", 99, Rarity.Common))

        addItem(Bananaclass(10.0))
        addItem(Bananaclass(50.0))
        addItem(Bananaclass(99.9))
    }

    fun addItem(item: Sellable){
        items.add(item)
    }
    fun sellAllItems(){
        items.forEach { item ->
            item.sellItem()
    }
    }
    fun showItems(){
    items.forEach { item ->
        when(item){
        is ClassMonkey -> println("Обезьяна: ${item.name} - Цена: ${item.price}")
        is Bananaclass-> println("Банан-Цена: ${item.price}")
        }
    }
    }
}
data class Kyct(
    val id: Int,
    val name: String,
    val price: Double,
)
fun  main(){
    val kekArray = arrayOf(
        Kyct(1,"мудрый дуб",120.0),
        Kyct(2,"мудрый олег",999.9),
        Kyct(3,"одуванчик",160.0),
        Kyct(4,"стрень",190.0)
    )
    println("введите индекс продукта:")
    val kok=readln().toInt()

    fun findKyct(id: Int):Kyct?{
        for(Kyct in kekArray){
            if (Kyct.id==id){
                return Kyct
            }
        }
        return null
    }

    val lol = findKyct(kok)

    if (lol!=null){
        println("куст для олэга:")
        println("ID: ${lol.id}")
        println("Имя куста олэга: ${lol.name}")
        println("Цена куста олэга: ${lol.price}")
    }  else {
        println("куст $kok ниту ")
    }
}
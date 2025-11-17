fun main() {
 val kek1:String= "сирень"
 val kek2:String= "жасмин"
 val kek3:String= "шиповник"
 val kek4:String= "одуванчик"
 val kek5:String= "розы"
    println("Выберите куст:{$kek1,$kek2,$kek3,$kek4,$kek5}" )
    val kek= readln()
        if (kek==kek1){
            println("100")
        }
        if (kek==kek2){
            println("120")
    }
        if (kek==kek3){
            println("150")
    }
        else{
            println("80")
        }
}
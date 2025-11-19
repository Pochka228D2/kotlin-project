fun Flowers(bashname: String): Int {
    return when(bashname) {
        "сирень" -> 150
        "шиповник" -> 800
        "гортензия" -> 2000
        else -> 0
    }
}

fun shopCastalog(shopList: Array<String>): Int {
    var total = 0
    for (bash in shopList) {
        val tekPrice = Flowers(bash)
        total += tekPrice
    }
    return total
}

fun main() {
    val shopCart = mutableListOf<String>()
    println("Хелло Олэг. Выбери кустик пжлст")
    println("Доступные кусты:сирень (150), шиповник (800), гортензия (2000)")
    println("Для завершения введите 'готово'")

    while(true) {
        println("введи название куста:")
        val input = readLine()?.lowercase()?.trim() ?: ""

        if (input == "готово") {
            break
        }

        if (input.isEmpty()) {
            println("ты че афигел...пиши куст..>:(")
            continue
        }

        val price = Flowers(input)
        if (price == 0) {
            println("нет куста '$input'")
        } else {
            shopCart.add(input)
            println("'$input' добавлен в корзину (цена: $price)")
        }
    }


    println("\n=== ТВОЯ КОРЗИНА ===")
    if (shopCart.isEmpty()) {
        println("Корзина пуста... грустно :(")
    } else {
        println("Твои кусты: ${shopCart.joinToString(", ")}")
        val totalPrice = shopCastalog(shopCart.toTypedArray())
        println("ИТОГО к оплате: $totalPrice рублей")
        println("Спасибо за покупку, Олэг!")
    }
}
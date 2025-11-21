data class Kyc(
    val id: Int,
    val name: String,
    var price: Double,
)

var kekArray = arrayOf(
    Kyc(1, "мудрый дуб", 120.0),
    Kyc(2, "мудрый олег", 999.9),
    Kyc(3, "одуванчик", 160.0),
    Kyc(4, "стрень", 190.0)
)

fun kekek(zzz: Double) {
    println("применяем скидочку $zzz%...")
    for (lol in kekArray) {
        val shark = lol.price * (zzz / 100)
        val kokk = lol.price - shark
        lol.price = kokk
    }
    println("скидка применена")
}

fun pocazKatalog() {
    println("\n=== каталог кустиков ===")
    for (kek in kekArray) {
        println("${kek.id}: ${kek.name} - ${kek.price} руб.")
    }
    println("========================")
}

fun findId(imya: String): Kyc? {
    for (kyst in kekArray) {
        if (kyst.name.lowercase() == imya.lowercase()) {
            return kyst
        }
    }
    return null
}

fun chikle() {
    val korzuna = mutableListOf<Kyc>()
    var obzayasumm = 0.0

    println("Добро пожаловать в магазин кустов!")
    pocazKatalog()

    while (true) {
        println("\nвведи куст (или 'готово' для выхода, 'скидка' для скидки):")
        val kokok = readln().trim()

        if (kokok == "готово") {
            break
        }

        if (kokok == "скидка") {
            println("Введите процент скидки:")
            val skidka = readln().toDoubleOrNull()
            if (skidka != null) {
                kekek(skidka)
                pocazKatalog()
            } else {
                println("Неправильный процент скидки!")
            }
            continue
        }

        val naydenniyKyst = findId(kokok)
        if (naydenniyKyst != null) {
            korzuna.add(naydenniyKyst)
            obzayasumm += naydenniyKyst.price
            println("'${naydenniyKyst.name}' добавлен в корзину! Цена: ${naydenniyKyst.price} руб.")
        } else {
            println("Куста '$kokok' не найдено!")
        }

        println("\n=== ТВОЯ КОРЗИНА ===")
        if (korzuna.isEmpty()) {
            println("Корзина пуста")
        } else {
            for (kyst in korzuna) {
                println("- ${kyst.name}: ${kyst.price} руб.")
            }
            println("=======================")
            println("ИТОГО: $obzayasumm руб.")
        }
    }

    println("\n=== ФИНАЛЬНЫЙ ЧЕК ===")
    if (korzuna.isEmpty()) {
        println("Вы ничего не купили...")
    } else {
        for (kyst in korzuna) {
            println("- ${kyst.name}: ${kyst.price} руб.")
        }
        println("=======================")
        println("ОБЩАЯ СУММА: $obzayasumm руб.")
        println("Спасибо за покупку! 🌿")
    }
}

fun main() {
    chikle()
}

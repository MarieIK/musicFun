const val PRICE = 100
const val DISCOUNT = 100
const val PURCHASE_FROM_1_000 = 1_000
const val PURCHASE_FROM_10_000 = 10_000
const val REGULAR_DISCOUNT = 0.95
const val SUPER_DISCOUNT = 0.99

fun main() {
    var totalAmount: Double
    val totalDiscount: Double

    println("Введите количество приобретаемых музыкальных треков: ")
    val count = readln().toInt()
    totalAmount = (count * PRICE).toDouble()
    println("Являетесь ли Вы постоянным покупателем (true/false)?")
    val regularCustomer = readln().toBoolean()

    if (regularCustomer && totalAmount > PURCHASE_FROM_1_000 && totalAmount <= PURCHASE_FROM_10_000) {
        totalAmount = (totalAmount - DISCOUNT) * SUPER_DISCOUNT
    } else if (regularCustomer && totalAmount > PURCHASE_FROM_10_000) {
        totalAmount = (totalAmount * REGULAR_DISCOUNT) * SUPER_DISCOUNT
    } else if (!regularCustomer && totalAmount > PURCHASE_FROM_1_000 && totalAmount <= PURCHASE_FROM_10_000) {
        totalAmount -= DISCOUNT
    } else if (!regularCustomer && totalAmount > PURCHASE_FROM_10_000) {
        totalAmount *= REGULAR_DISCOUNT
    }

    totalDiscount = (count * PRICE) - totalAmount

    println(
        """
        Вы хотите приобрести: $count шт.
        Ваша скидка: $totalDiscount руб.
        Сумма покупки составит: $totalAmount руб. 
        """.trimIndent()
    )

}
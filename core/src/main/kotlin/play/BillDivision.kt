package play

fun billDivision(bill: Array<Int>, k: Int, b: Int): Int {
    var annaI = 0
    val annaBill = bill
        .fold(0) { acc, it ->
            val ret = if (annaI == k) {
                acc
            } else {
                acc + it
            }
            annaI++
            return@fold ret
        }
        .div(2)

    return b - annaBill
}

/**
 * [https://www.hackerrank.com/challenges/bon-appetit]
 */
internal fun bonAppetit(bill: Array<Int>, k: Int, b: Int) {
    val out = billDivision(bill, k, b)

    if (out == 0) {
        println("Bon Appetit")
    } else {
        println(out.toString())
    }
}

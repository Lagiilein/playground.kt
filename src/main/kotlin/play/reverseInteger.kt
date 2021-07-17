package play

import kotlin.math.absoluteValue

/**
 * [https://leetcode.com/problems/reverse-integer/]
 */
fun reverseInteger(x: Int): Int {
    return try {
        val negative = x < 0

        val str = x.absoluteValue.toString().reversed()
        "${if (negative) "-" else ""}$str".toInt()
    } catch (ex: NumberFormatException) {
        0
    }
}

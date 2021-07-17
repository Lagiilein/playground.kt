package play

import kotlin.math.abs

/**
 * [https://leetcode.com/problems/reverse-integer/]
 */
fun reverseInteger(x: Int, radix: Int = 10): Int {

    val neg = x < 0
    var num = abs(x)
    var rev = 0L

    while (num > 0) {
        val digit = num % radix

        rev = rev * radix + digit
        num /= radix
    }

    if (rev > Int.MAX_VALUE) {
        return 0
    }

    return if (neg) {
        rev.toInt() * -1
    } else {
        rev.toInt()
    }
}

package play

/**
 * @see [https://www.hackerrank.com/challenges/electronics-shop/problem]
 */
fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
    val filter: (Int) -> Boolean = { it in 1 until b }

    val one = keyboards.filter(filter)
    val two = drives.filter(filter)

    var cOne: Int? = null
    var cTwo: Int? = null

    for (first in one) {
        for (second in two) {
            if (first + second > b) {
                continue
            }

            if (cOne == null && cTwo == null) {
                cOne = first
                cTwo = second
                continue
            }

            check(!(cOne == null || cTwo == null)) {
                "One of the temporary variables is null, but not both. "
            }

            if (first + second > cOne + cTwo) {
                cOne = first
                cTwo = second
            }
        }
    }

    return if (cOne != null && cTwo != null) {
        cOne + cTwo
    } else {
        -1
    }
}

package play

import kotlin.math.min

/**
 * [https://www.hackerrank.com/challenges/drawing-book]
 */
fun pageTurnsNeeded(n: Int, p: Int): Int {
    val turnsFromStart = (p) / 2
    val turnsFromEnd = ((n - p) / 2)
        .plus(if (n % 2 == 0 && p % 2 == 1 && n != p) 1 else 0)

    return min(turnsFromStart, turnsFromEnd)
}

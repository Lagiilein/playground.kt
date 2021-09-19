package play

import play.exception.NoSolutionException
import java.util.TreeSet

/**
 * @see [https://www.hackerrank.com/challenges/minimum-loss/problem]
 */
fun minimumLoss(price: Array<Long>): Long {
    require(price.size >= 2)

    var best: Long? = null

    val tree = TreeSet<Long>()
    tree.add(price.first())

    for (i in price.indices) {
        val v = price[i]
        val higher = tree.higher(v)

        higher?.let { high ->
            val cur = high - v
            if (cur <= 0) return@let
            if (best == null || cur < best!!) {
                best = cur
            }
        }

        tree.add(v)
    }

    return best ?: throw NoSolutionException()
}

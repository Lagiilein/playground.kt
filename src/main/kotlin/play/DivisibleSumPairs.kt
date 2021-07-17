package play

/**
 * [https://www.hackerrank.com/challenges/divisible-sum-pairs/problem]
 */
fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    var pairs = 0

    for (i in ar.indices) {
        for (j in (i + 1) until ar.size) {
            if (i >= j) continue // shouldn't happen, but just in case

            val sum = ar[i] + ar[j]
            if (sum % k == 0) {
                pairs++
            }
        }
    }

    return pairs
}

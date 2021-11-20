package com.github.lagiilein.playground.jvm

/**
 * [https://www.hackerrank.com/challenges/divisible-sum-pairs/problem]
 */
fun divisibleSumPairs(@Suppress("UNUSED_PARAMETER") ignored: Int, k: Int, arr: Array<Int>): Int {
    var pairs = 0

    val buckets = List<MutableList<Int>>(k) {
        mutableListOf()
    }

    // fill buckets with input
    for (item in arr) {
        buckets[item % k] += item
    }

    // add number of pairs of bucket 0
    val zeroBucketSize = buckets[0].size
    pairs += zeroBucketSize * (zeroBucketSize - 1) / 2

    // add number of pairs of other buckets
    for (i in 1..(k / 2)) {
        if (k % 2 == 0 && i == k / 2) continue
        pairs += buckets[i].size * buckets[k - i].size
    }

    // add number of pairs of the half k bucket
    if (k % 2 == 0) {
        val halfKBucketSize = buckets[k / 2].size
        pairs += halfKBucketSize * (halfKBucketSize - 1) / 2
    }

    return pairs
}

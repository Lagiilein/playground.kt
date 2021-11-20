package com.github.lagiilein.playground.jvm

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    require(n == ar.size)

    var pairs = 0
    val waitingForPair = hashSetOf<Int>()

    ar.forEach {
        if (waitingForPair.contains(it)) {
            waitingForPair.remove(it)
            pairs++
        } else {
            waitingForPair.add(it)
        }
    }

    return pairs
}

package com.github.lagiilein.playground.jvm

/**
 * [https://www.hackerrank.com/challenges/migratory-birds/problem]
 */
fun migratoryBirds(arr: Array<Int>): Int {

    val frequencies = mutableMapOf<Int, Int>()

    arr.forEach {
        frequencies[it] = (frequencies[it] ?: 0) + 1
    }

    var biggestId = arr[0]
    var currentBiggest = 0

    frequencies.onEach {
        if (it.value > currentBiggest) {
            biggestId = it.key
            currentBiggest = it.value
        } else if (it.value == currentBiggest) {
            if (it.key < biggestId) {
                biggestId = it.key
                currentBiggest = it.value
            }
        }
    }

    return biggestId
}

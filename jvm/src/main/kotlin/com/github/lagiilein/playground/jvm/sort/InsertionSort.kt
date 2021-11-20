package com.github.lagiilein.playground.jvm.sort

fun <T : Comparable<T>> MutableList<T>.insertionSort(lo: Int = 0, hi: Int = size - 1) {
    for (i in (lo + 1)..hi) {
        val key = this[i]
        var j = i - 1

        while (j >= 0 && this[j] > key) {
            this[j + 1] = this[j]
            j--
        }

        this[j + 1] = key
    }
}

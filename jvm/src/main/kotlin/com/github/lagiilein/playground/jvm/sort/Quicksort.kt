package com.github.lagiilein.playground.jvm.sort

private fun <T> MutableList<T>.swap(firstIndex: Int, secondIndex: Int) {
    val e = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = e
}

private fun <T : Comparable<T>> MutableList<T>.quickSortPartition(lo: Int, hi: Int): Int {
    val pivot = this[(lo + hi) / 2]

    var i = lo - 1
    var j = hi + 1

    while (true) {
        do {
            i++
        } while (this[i] < pivot)

        do {
            j--
        } while (this[j] > pivot)

        if (i >= j) {
            return j
        }

        this.swap(j, i)
    }
}

fun <T : Comparable<T>> MutableList<T>.quickSort(lo: Int = 0, hi: Int = size - 1) {
    if (lo < hi) {
        val p = quickSortPartition(lo, hi)
        quickSort(lo, p)
        quickSort(p + 1, hi)
    }
}

/**
 * uses QuickSort, but if the number of elements goes under a certain threshold, it switches to InsertionSort.
 */
fun <T : Comparable<T>> MutableList<T>.quickInsertionSort(lo: Int = 0, hi: Int = size - 1, threshold: Int = 6) {
    if (lo < hi) {
        if (hi - lo <= threshold) {
            this.insertionSort(lo, hi)
        } else {
            val p = quickSortPartition(lo, hi)
            quickInsertionSort(lo, p)
            quickInsertionSort(p + 1, hi)
        }
    }
}

internal fun <T : Comparable<T>> MutableList<T>.quickSort1() {
    fun swap(first: Int, second: Int) {
        val e = this[first]
        this[first] = this[second]
        this[second] = e
    }

    fun partition(lo: Int, hi: Int): Int {
        val pivot = this[hi]
        var i = lo

        for (j in lo until hi) {
            if (this[j] < pivot) {
                swap(i, j)
                i++
            }
        }
        swap(i, hi)
        return i
    }

    fun quickSort(lo: Int, hi: Int) {
        if (lo < hi) {
            val p = partition(lo, hi)
            quickSort(lo, p - 1)
            quickSort(p + 1, hi)
        }
    }

    quickSort(this.indices.first, this.indices.last)
}

internal fun <T : Comparable<T>> MutableList<T>.quickSort2() {
    fun swap(first: Int, second: Int) {
        val e = this[first]
        this[first] = this[second]
        this[second] = e
    }

    fun partition(lo: Int, hi: Int): Int {

        val mid = (lo + hi) / 2

        if (this[mid] < this[lo]) {
            swap(lo, mid)
        } else if (this[hi] < this[lo]) {
            swap(lo, hi)
        } else if (this[mid] < this[hi]) {
            swap(mid, hi)
        }

        val pivot = this[hi]

        var i = lo

        for (j in lo until hi) {
            if (this[j] < pivot) {
                swap(i, j)
                i++
            }
        }
        swap(i, hi)
        return i
    }

    fun quickSort(lo: Int, hi: Int) {
        if (lo < hi) {
            val p = partition(lo, hi)
            quickSort(lo, p - 1)
            quickSort(p + 1, hi)
        }
    }

    quickSort(this.indices.first, this.indices.last)
}

internal fun <T : Comparable<T>> MutableList<T>.quickSort3() {
    fun swap(first: Int, second: Int) {
        val e = this[first]
        this[first] = this[second]
        this[second] = e
    }

    fun partition(lo: Int, hi: Int): Int {

        val pivot = this[(lo + hi) / 2]

        var i = lo - 1
        var j = hi + 1

        while (true) {
            do {
                i++
            } while (this[i] < pivot)

            do {
                j--
            } while (this[j] > pivot)

            if (i >= j) {
                return j
            }

            swap(j, i)
        }
    }

    fun quickSort(lo: Int, hi: Int) {
        if (lo < hi) {
            val p = partition(lo, hi)
            quickSort(lo, p)
            quickSort(p + 1, hi)
        }
    }

    quickSort(this.indices.first, this.indices.last)
}

internal fun <T : Comparable<T>> MutableList<T>.quickSort4() {
    fun swap(first: Int, second: Int) {
        val e = this[first]
        this[first] = this[second]
        this[second] = e
    }

    fun partition(lo: Int, hi: Int): Int {

        val mid = (lo + hi) / 2

        if (this[mid] < this[lo]) {
            swap(lo, mid)
        } else if (this[hi] < this[lo]) {
            swap(lo, hi)
        } else if (this[mid] < this[hi]) {
            swap(mid, hi)
        }

        val pivot = this[hi]

        var i = lo - 1
        var j = hi + 1

        while (true) {
            do {
                i++
            } while (this[i] < pivot)

            do {
                j--
            } while (this[j] > pivot)

            if (i >= j) {
                return j
            }

            swap(j, i)
        }
    }

    fun quickSort(lo: Int, hi: Int) {
        if (lo < hi) {
            val p = partition(lo, hi)
            quickSort(lo, p)
            quickSort(p + 1, hi)
        }
    }

    quickSort(this.indices.first, this.indices.last)
}

internal fun <T : Comparable<T>> MutableList<T>.quickSort5() {
    fun partition(lo: Int, hi: Int): Int {
        val pivot = this[hi]

        var i = lo
        var j = hi - 1

        while (i < j) {
            while (i < hi && this[i] < pivot) {
                i++
            }

            while (j > lo && this[j] >= pivot) {
                j--
            }

            if (i < j) {
                swap(i, j)
            }
        }

        if (this[i] > pivot) {
            swap(i, hi)
        }

        return i
    }

    fun quickSort(lo: Int, hi: Int) {
        if (lo < hi) {
            val p = partition(lo, hi)
            quickSort(lo, p - 1)
            quickSort(p + 1, hi)
        }
    }

    quickSort(this.indices.first, this.indices.last)
}

internal fun <T : Comparable<T>> MutableList<T>.quickSort6() {
    fun partition(lo: Int, hi: Int): Int {

        val mid = (lo + hi) / 2

        if (this[mid] < this[lo]) {
            swap(lo, mid)
        } else if (this[hi] < this[lo]) {
            swap(lo, hi)
        } else if (this[mid] < this[hi]) {
            swap(mid, hi)
        }

        val pivot = this[hi]

        var i = lo
        var j = hi - 1

        while (i < j) {
            while (i < hi && this[i] < pivot) {
                i++
            }

            while (j > lo && this[j] >= pivot) {
                j--
            }

            if (i < j) {
                swap(i, j)
            }
        }

        if (this[i] > pivot) {
            swap(i, hi)
        }

        return i
    }

    fun quickSort(lo: Int, hi: Int) {
        if (lo < hi) {
            val p = partition(lo, hi)
            quickSort(lo, p - 1)
            quickSort(p + 1, hi)
        }
    }

    quickSort(this.indices.first, this.indices.last)
}

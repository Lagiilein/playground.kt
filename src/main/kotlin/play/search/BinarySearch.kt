package play.search

import kotlin.math.abs

/**
 * Search an item in a sorted list using Binary Search.
 *
 * This method expect that the list is sorted. There will be no check, if this really is so.
 *
 * @param search The Item the list is searched for.
 * @return the index of an item that equals the search item or -1 if no item could be found.
 */
fun <T : Comparable<T>> List<T>.binarySearch(search: T): Int {
    var low = 0
    var high = this.size - 1

    if (isNotEmpty()) {
        while (true) {
            when (val remainingLength = abs(high - low)) {
                0 -> {
                    if (this[low] == search) {
                        return low
                    } else {
                        break
                    }
                }

                1 -> {
                    if (this[low] == search) {
                        return low
                    }

                    if (this[high] == search) {
                        return high
                    }

                    break
                }

                else -> {
                    val middle = low + remainingLength / 2
                    val middleItem = this[middle]

                    if (search > middleItem) {
                        low = middle
                    } else if (search < middleItem) {
                        high = middle
                    } else {
                        return middle
                    }
                }
            }
        }
    }

    return -1
}

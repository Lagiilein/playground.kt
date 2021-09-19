package play

/**
 * @see [https://www.hackerrank.com/challenges/big-sorting/problem]
 */
fun bigSorting(unsorted: Array<String>, radix: Int = 10): Array<String> {
    val comp = Comparator<String> { o1, o2 ->
        val v1 = o1.trim().trimStart('0')
        val v2 = o2.trim().trimStart('0')

        if (v1 == v2) return@Comparator 0

        if (v1.length != v2.length) {
            return@Comparator v1.length.compareTo(v2.length)
        } else {
            for (i in v1.indices) {
                val c1 = v1[i]
                val c2 = v2[i]

                if (c1 == c2) continue

                return@Comparator c1.digitToInt(radix).compareTo(c2.digitToInt(radix))
            }
        }

        return@Comparator 0
    }

    unsorted.sortWith(comp)
    return unsorted
}

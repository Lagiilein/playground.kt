package play

/**
 * [https://www.hackerrank.com/challenges/the-birthday-bar/problem]
 */
fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    var result = 0

    s.forEachIndexed { outerIndex, it ->
        if (outerIndex > (s.size - m)) return@forEachIndexed

        var sum = it
        for (innerIndex in 1 until m) {
            sum += s[outerIndex + innerIndex]
        }

        if (sum == d) {
            result++
        }
    }

    return result
}

package play

/**
 * [https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem]
 */
fun breakingRecords(scores: Array<Int>): Array<Int> {
    assert(scores.isNotEmpty())

    var lowest = scores[0]
    var highest = scores[0]

    var highestRecordBroken = 0
    var lowestRecordBroken = 0

    scores.forEach {
        if (it > highest) {
            highestRecordBroken++
            highest = it
        } else if (it < lowest) {
            lowestRecordBroken++
            lowest = it
        }
    }

    return arrayOf(highestRecordBroken, lowestRecordBroken)
}

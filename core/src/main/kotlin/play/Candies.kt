package play

@OptIn(ExperimentalUnsignedTypes::class)
fun candies(arr: Array<Int>): Long {
    val candies = UIntArray(arr.size) { 0u }

    fun leftToRight() {
        var currentCandy = 1u
        var previousScore: Int? = null

        for (i in arr.indices) {
            val currentScore = arr[i]

            if (previousScore != null) {
                if (previousScore < currentScore) {
                    currentCandy++
                } else if (previousScore >= currentScore) {
                    currentCandy = 1u
                }
            }

            candies[i] = currentCandy
            previousScore = currentScore
        }
    }

    fun rightToLeft() {
        var previousScore: Int? = null
        var previousCandy: UInt? = null

        for (i in arr.indices.reversed()) {
            val currentScore = arr[i]
            val currentCandy = candies[i]

            previousScore?.let { prevScore ->
                previousCandy?.let { prevCandy ->
                    if (currentScore > prevScore && currentCandy <= prevCandy) {
                        candies[i] = previousCandy!! + 1u
                    }
                }
            }

            previousCandy = candies[i]
            previousScore = currentScore
        }
    }

    leftToRight()
    rightToLeft()

    var sum: Long = 0
    for (it in candies) {
        sum += it.toLong()
    }
    return sum
}

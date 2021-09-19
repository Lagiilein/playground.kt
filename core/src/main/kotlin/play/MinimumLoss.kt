package play

import play.exception.NoSolutionException

fun minimumLoss(price: Array<Long>): Long {
    require(price.size >= 2)

    var minimumLoss: Long? = null

    for ((i, first) in price.withIndex()) {
        for (j in (i + 1) until price.size) {
            val currentLoss = first - price[j]

            if (currentLoss <= 0) continue

            if (minimumLoss == null || currentLoss < minimumLoss) {
                minimumLoss = currentLoss
            }
        }
    }

    return minimumLoss ?: throw NoSolutionException()
}

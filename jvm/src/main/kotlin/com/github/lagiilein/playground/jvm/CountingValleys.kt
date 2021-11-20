package com.github.lagiilein.playground.jvm

/**
 * [https://www.hackerrank.com/challenges/counting-valleys]
 *
 * @param path Each character represents one unit change in altitude. 'D' represents downwards, 'U' upwards. The path always starts at sea level
 *
 * @return the number of valleys.
 */
fun countingValleys(path: String): Int {
    var valleyCount = 0
    var level = 0
    path.forEach { step ->
        when (step) {
            'U' -> {
                if (level == -1) {
                    valleyCount++
                }
                level++
            }

            'D' -> {
                level--
            }

            else -> {
                throw IllegalArgumentException("Step $step (${step.code}) is not supported. ")
            }
        }
    }

    return valleyCount
}

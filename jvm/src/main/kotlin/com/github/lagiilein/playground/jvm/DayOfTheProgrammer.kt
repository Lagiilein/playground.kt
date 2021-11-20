package com.github.lagiilein.playground.jvm

private const val MODERN_START = 1919
private const val OLD_START = 1700

private const val FOUR = 4
private const val ONE_HUNDRED = 100

/**
 * [https://www.hackerrank.com/challenges/day-of-the-programmer/problem]
 */
fun dayOfProgrammer(year: Int): String {
    val dayWithoutLeap = lazy {
        "13.09.$year"
    }
    val dayWithLeap = lazy {
        "12.09.$year"
    }

    when {
        year >= MODERN_START -> { // modern (gregorian calendar)
            return if (
                (year % (FOUR * ONE_HUNDRED) == 0) || (year % FOUR == 0 && year % ONE_HUNDRED != 0)
            ) {
                dayWithLeap.value
            } else {
                dayWithoutLeap.value
            }
        }

        year == (MODERN_START - 1) -> { // transition Feb, 14th is 32nd day
            return "30.08.$year"
        }

        year in OLD_START until (MODERN_START - 1) -> { // older (julian calendar)
            return if (year % FOUR == 0) {
                dayWithLeap.value
            } else {
                dayWithoutLeap.value
            }
        }
    }

    throw IllegalArgumentException("year is out of range")
}

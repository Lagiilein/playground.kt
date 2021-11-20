package com.github.lagiilein.playground.jvm

import kotlin.math.pow

/**
 * [https://www.hackerrank.com/challenges/marcs-cakewalk/problem]
 */
fun marcsCakewalk(calories: List<Int>): Long {
    val orderedCalories = calories.sortedDescending()

    var sum = 0L
    for ((index, value) in orderedCalories.withIndex()) {
        sum += 2.0.pow(index.toDouble()).toLong() * value
    }

    return sum
}

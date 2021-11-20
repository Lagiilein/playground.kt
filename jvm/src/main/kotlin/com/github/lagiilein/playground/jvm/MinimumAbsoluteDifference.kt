package com.github.lagiilein.playground.jvm

import com.github.lagiilein.playground.jvm.exception.NoSolutionException
import java.util.TreeSet
import kotlin.math.abs

/**
 * [https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem]
 * @throws NoSolutionException when no solution found.
 */
fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    var best: Int? = null

    val tree = TreeSet<Int>()

    for (it in arr) {
        if (tree.contains(it)) {
            return 0
        }

        tree.add(it)
    }

    for (it in arr) {
        val higher = tree.higher(it) ?: continue
        val cur = abs(higher - it)
        if (best == null || cur < best) {
            best = cur
        }
    }

    return best ?: throw NoSolutionException()
}

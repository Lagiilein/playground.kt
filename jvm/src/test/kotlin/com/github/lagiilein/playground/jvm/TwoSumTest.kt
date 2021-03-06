package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

internal class TwoSumTest {

    @OptIn(ExperimentalTime::class)
    @Test
    fun twoSum() {
        val t1 = measureTime {
            assertArrayEquals(
                intArrayOf(0, 1),
                twoSum(intArrayOf(2, 7, 11, 15), 9),
            )
            assertArrayEquals(intArrayOf(1, 2), twoSum(intArrayOf(3, 2, 4), 6))
            assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(3, 3), 6))
        }

        val t2 = measureTime {
            assertArrayEquals(intArrayOf(0, 1), twoSumFast(intArrayOf(2, 7, 11, 15), 9))
            assertArrayEquals(intArrayOf(1, 2), twoSumFast(intArrayOf(3, 2, 4), 6))
            assertArrayEquals(intArrayOf(0, 1), twoSumFast(intArrayOf(3, 3), 6))
        }

        println("total time for twoSum = $t1")
        println("total time for twoSumFast = $t2")
    }
}

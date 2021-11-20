package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DivisibleSumPairsTest {

    @Test
    fun divisibleSumPairs() {
        assertEquals(5, divisibleSumPairs(6, 3, arrayOf(1, 3, 2, 6, 1, 2)))
        assertEquals(3, divisibleSumPairs(6, 5, arrayOf(1, 2, 3, 4, 5, 6)))
        assertEquals(7, divisibleSumPairs(7, 3, arrayOf(1, 3, 2, 6, 4, 5, 9)))
        assertEquals(4, divisibleSumPairs(5, 2, arrayOf(5, 9, 10, 7, 4)))
    }
}

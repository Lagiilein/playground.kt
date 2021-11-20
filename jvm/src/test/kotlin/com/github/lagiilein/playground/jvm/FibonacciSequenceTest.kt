package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class FibonacciSequenceTest {

    @Test
    fun `test fibonacciSequence`() {
        assertArrayEquals(
            listOf<Long>(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144).map { BigInteger.valueOf(it) }.toTypedArray(),
            fibonacciSequence.take(13).toList().toTypedArray()
        )
    }

    @Test
    fun `test fibonacciNumber`() {
        assertEquals(BigInteger.valueOf(610), fibonacciNumber(15))
        assertEquals(BigInteger("7896325826131730509282738943634332893686268675876375"), fibonacciNumber(250))
    }
}

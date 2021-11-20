package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BillDivisionTest {

    @Test
    fun `test billDivision`() {

        assertEquals(3, billDivision(arrayOf(2, 4, 6), 2, 6))
        assertEquals(5, billDivision(arrayOf(3, 10, 2, 9), 1, 12))
        assertEquals(0, billDivision(arrayOf(3, 10, 2, 9), 1, 7))
    }
}

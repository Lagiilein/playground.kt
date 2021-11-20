package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DrawingBookTest {

    @Test
    fun `test pageTurnsNeeded`() {

        assertEquals(1, pageTurnsNeeded(5, 3))
        assertEquals(1, pageTurnsNeeded(6, 2))
        assertEquals(0, pageTurnsNeeded(5, 4))
        assertEquals(0, pageTurnsNeeded(4, 4))
        assertEquals(1, pageTurnsNeeded(6, 4))
        assertEquals(1, pageTurnsNeeded(6, 5))
    }
}

package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CountingValleysTest {

    @Test
    fun `test countingValleys`() {
        assertEquals(1, countingValleys("UDDDUDUU"))
    }
}

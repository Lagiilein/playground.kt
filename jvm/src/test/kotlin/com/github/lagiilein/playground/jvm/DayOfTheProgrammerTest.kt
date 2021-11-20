package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayOfTheProgrammerTest {

    @Test
    fun `test day of the programmer`() {
        assertEquals("13.09.2017", dayOfProgrammer(2017))
        assertEquals("12.09.2016", dayOfProgrammer(2016))
        assertEquals("12.09.1800", dayOfProgrammer(1800))
        assertEquals("30.08.1918", dayOfProgrammer(1918))
    }
}

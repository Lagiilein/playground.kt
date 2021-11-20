package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class ExtraLongFactorialsTest {

    @Test
    fun `test extra long factorials`() {
        assertEquals(BigInteger("15511210043330985984000000"), extraLongFactorials(25))
        assertEquals(BigInteger("265252859812191058636308480000000"), extraLongFactorials(30))
    }
}

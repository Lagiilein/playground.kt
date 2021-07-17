package play

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReverseIntegerTest {

    @Test
    fun reverseInteger() {
        assertEquals(321, reverseInteger(123))
        assertEquals(-321, reverseInteger(-123))
        assertEquals(21, reverseInteger(120))
        assertEquals(0, reverseInteger(0))
    }
}

package play

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DivisibleSumPairsTest {

    @Test
    fun divisibleSumPairs() {
        assertEquals(5, divisibleSumPairs(6, 3, arrayOf(1, 3, 2, 6, 1, 2)))
        assertEquals(3, divisibleSumPairs(6, 5, arrayOf(1, 2, 3, 4, 5, 6)))
    }
}

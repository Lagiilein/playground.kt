package play

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CountingValleysTest {

    @Test
    fun `test countingValleys`() {
        assertEquals(1, countingValleys("UDDDUDUU"))
    }
}

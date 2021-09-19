package play

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinimumLossTest {

    @Test
    fun minimumLoss() {
        assertEquals(3, minimumLoss(arrayOf(20, 15, 8, 2, 12)))
        assertEquals(2, minimumLoss(arrayOf(5, 10, 3)))
        assertEquals(2, minimumLoss(arrayOf(20, 7, 8, 2, 5)))
    }
}

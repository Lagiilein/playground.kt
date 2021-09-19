package play

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ElectronicsShopTest {

    @Test
    fun getMoneySpent() {
        assertEquals(58, getMoneySpent(arrayOf(40, 50, 60), arrayOf(5, 8, 12), 60))
        assertEquals(9, getMoneySpent(arrayOf(3, 1), arrayOf(5, 2, 8), 10))
        assertEquals(-1, getMoneySpent(arrayOf(4), arrayOf(5), 5))
    }
}

package play

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TheBirthdayBarTest {

    @Test
    fun birthday() {
        assertEquals(2, birthday(arrayOf(2, 2, 1, 3, 2), 4, 2))
        assertEquals(0, birthday(arrayOf(1, 1, 1, 1, 1, 1), 3, 2))
        assertEquals(1, birthday(arrayOf(4), 4, 1))
    }
}

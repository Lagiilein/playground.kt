package play

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MigratoryBirdsTest {

    @Test
    fun migratoryBirds() {
        assertEquals(1, migratoryBirds(arrayOf(1, 1, 2, 2, 3)))
        assertEquals(4, migratoryBirds(arrayOf(1, 4, 4, 4, 5, 3)))
        assertEquals(3, migratoryBirds(arrayOf(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)))
    }
}

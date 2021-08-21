package play

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class MagicSquareTest {

    @Test
    fun isSquareMagic() {
        assertTrue(
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(8, 3, 4),
                    listOf(1, 5, 9),
                    listOf(6, 7, 2)
                )
            )
        )

        assertFalse(
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(5, 3, 4),
                    listOf(1, 5, 8),
                    listOf(6, 4, 2)
                )
            )
        )

        assertFalse(
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(5, 3, 4),
                    listOf(1, 5, 8),
                    listOf(6, 4, 2)
                )
            )
        )

        assertFalse {
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(4, 8, 2),
                    listOf(4, 5, 7),
                    listOf(6, 1, 6)
                )
            )
        }

        assertFalse {
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(6)
                )
            )
        }

        assertTrue {
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(1)
                )
            )
        }

        assertTrue(
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(4, 9, 2),
                    listOf(3, 5, 7),
                    listOf(8, 1, 6)
                )
            )
        )

        assertTrue {
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(2, 16, 13, 3),
                    listOf(11, 5, 8, 10),
                    listOf(7, 9, 12, 6),
                    listOf(14, 4, 1, 15)
                )
            )
        }

        assertFalse {
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(17, 16, 13, 3),
                    listOf(11, 5, 8, 10),
                    listOf(7, 9, 12, 6),
                    listOf(14, 4, 1, 15)
                )
            )
        }

        assertTrue {
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(1, 23, 16, 4, 21),
                    listOf(15, 14, 7, 18, 11),
                    listOf(24, 17, 13, 9, 2),
                    listOf(20, 8, 19, 12, 6),
                    listOf(5, 3, 10, 22, 25)
                )
            )
        }

        assertTrue {
            MagicSquare.isSquareMagic(
                listOf(
                    listOf(31, 76, 13, 36, 81, 18, 29, 74, 11),
                    listOf(22, 40, 58, 27, 45, 63, 20, 38, 56),
                    listOf(67, 4, 49, 72, 9, 54, 65, 2, 47),
                    listOf(30, 75, 12, 32, 77, 14, 34, 79, 16),
                    listOf(21, 39, 57, 23, 41, 59, 25, 43, 61),
                    listOf(66, 3, 48, 68, 5, 50, 70, 7, 52),
                    listOf(35, 80, 17, 28, 73, 10, 33, 78, 15),
                    listOf(26, 44, 62, 19, 37, 55, 24, 42, 60),
                    listOf(71, 8, 53, 64, 1, 46, 69, 6, 51)
                )
            )
        }
    }
}

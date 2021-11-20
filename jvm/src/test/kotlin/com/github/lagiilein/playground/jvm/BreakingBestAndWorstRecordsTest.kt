package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class BreakingBestAndWorstRecordsTest {

    @Test
    fun breakingRecords() {
        assertArrayEquals(
            breakingRecords(
                arrayOf(
                    10, 5, 20, 20, 4, 5, 2, 25, 1
                )
            ),
            arrayOf(2, 4)
        )

        assertArrayEquals(
            breakingRecords(
                arrayOf(
                    3, 4, 21, 36, 10, 28, 35, 5, 24, 42
                )
            ),
            arrayOf(4, 0)
        )
    }
}

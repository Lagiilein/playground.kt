package com.github.lagiilein.playground.jvm

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class BigSortingTest {

    @Test
    fun bigSorting() {
        assertArrayEquals(
            arrayOf("1", "3", "150", "200"),
            bigSorting(arrayOf("1", "200", "150", "3"))
        )
        assertArrayEquals(
            arrayOf(
                "1",
                "3",
                "3",
                "5",
                "10",
                "31415926535897932384626433832795"
            ),
            bigSorting(
                arrayOf(
                    "31415926535897932384626433832795",
                    "1",
                    "3",
                    "10",
                    "3",
                    "5"
                )
            )
        )
    }
}

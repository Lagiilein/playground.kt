package com.github.lagiilein.playground.jvm.search

import com.github.lagiilein.playground.jvm.sort.quickInsertionSort
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertNotEquals

internal class BinarySearchTest {

    @Test
    fun `test binarySearch`() {
        assertEquals(
            -1,
            mutableListOf(5345, 53, 5346754, 6345, 42342, 654).apply { this.quickInsertionSort() }.binarySearch(342)
        )

        assertEquals(
            0,
            listOf(5345, 5345867, 5345867, 53458675, 534586754, 534586764).binarySearch(5345)
        )

        assertEquals(-1, listOf<Int>().binarySearch(532424))

        assertEquals(4, listOf(-432f, 3.0f, 3.99f, 3.999f, 4f, 423423f).binarySearch(4f))

        for (i in 0 until 10) {
            val list = Random.nextBytes(512).toMutableList()
            list.quickInsertionSort()

            val search = Random.nextBytes(1).first()
            val binarySearchResult = list.binarySearch(search)
            if (list.contains(search)) {
                assertNotEquals(-1, binarySearchResult)
                assertEquals(search, list[binarySearchResult])
            } else {
                assertEquals(-1, binarySearchResult)
            }
        }
    }
}

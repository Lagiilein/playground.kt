package play.sort

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class QuickSortingTest {

    private val testList = listOf(
        0, 532, 563, 63, 643, 643, 42, 432, 5, 21, -253, 325
    )

    private inline fun <reified T> assertListEquals(expected: List<T>, actual: List<T>) {
        Assertions.assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun `test quicksort sort on small list`() {
        val list = testList.toMutableList()

        list.quickSort()

        assertListEquals(testList.sorted(), list)
    }

    @Test
    fun `test insertion sort on small list`() {
        val list = testList.toMutableList()

        list.insertionSort()

        assertListEquals(testList.sorted(), list)
    }

    @Test
    fun `test quick-insertion sort on small list`() {
        val list = testList.toMutableList()

        list.quickInsertionSort(threshold = 4)

        assertListEquals(testList.sorted(), list)
    }
}

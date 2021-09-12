package play

import org.junit.jupiter.api.Test
import play.search.binarySearch
import play.sort.quickInsertionSort
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class HashSetTimeTest {

    @OptIn(ExperimentalTime::class)
    @Test
    fun `test HashSet times`() {

        val list = mutableListOf<Int>().apply {
            (0 until 100000).map {
                val rnd = Random.nextInt()
                if (!contains(rnd)) {
                    add(rnd)
                }
            }
        }

        val set = list.toHashSet()

        list.quickInsertionSort()

        var durationHashSet = Duration.ZERO
        var durationBinarySearch = Duration.ZERO

        (0 until 50000).forEach { _ ->

            val search = Random.nextInt()

            val resultBinarySearch = measureTimedValue {
                list.binarySearch(search)
            }

            val resultHashSet = measureTimedValue {
                set.contains(search)
            }

            val realResult = list.contains(search)
            assertEquals(realResult, resultBinarySearch.value != -1)
            assertEquals(realResult, resultHashSet.value)

            durationBinarySearch += resultBinarySearch.duration
            durationHashSet += resultHashSet.duration
        }

        println("Total Duration HashSet: $durationHashSet")
        println("Total Duration BinarySearch: $durationBinarySearch")
    }
}

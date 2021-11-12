package play.sort

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortTest {
    private val testLists: MutableList<MutableList<Int>> =
        mutableListOf(
            mutableListOf(
                0, 532, 563, 63, 643, 643, 42, 432, 5, 21, -253, 325
            )
        )

    private val testMethods: MutableMap<String, (it: MutableList<Long>) -> Unit> =
        mutableMapOf()

    @BeforeAll
    @Suppress("unused")
    fun before() {
        testMethods[".sort()"] = {
            it.sort()
        }

        testMethods["quicksort"] = {
            it.quickSort()
        }

        testMethods["quicksort1"] = {
            it.quickSort1()
        }

        testMethods["quicksort2"] = {
            it.quickSort2()
        }

        testMethods["quicksort3"] = {
            it.quickSort3()
        }

        testMethods["quicksort4"] = {
            it.quickSort4()
        }

        testMethods["quicksort5"] = {
            it.quickSort5()
        }

        testMethods["quicksort6"] = {
            it.quickSort6()
        }

        testMethods["insertion sort"] = {
            it.insertionSort()
        }

        testMethods["quick insertion sort (12)"] = {
            it.quickInsertionSort(threshold = 12)
        }

        testMethods["quick insertion sort (6)"] = {
            it.quickInsertionSort(threshold = 6)
        }

        testMethods["quick insertion sort (8)"] = {
            it.quickInsertionSort(threshold = 8)
        }

        testMethods["quick insertion sort (4)"] = {
            it.quickInsertionSort(threshold = 4)
        }
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun `test sorting algorithms times`() {
        val times = mutableMapOf<String, MutableList<Duration>>()

        fun testList(it: MutableList<Long>) {
            for ((name, block) in testMethods) {
                val list = it.toMutableList()

                val time = measureTime {
                    block(list)
                }

                val prevTimes = times[name] ?: mutableListOf()
                prevTimes.add(time)
                times[name] = prevTimes

                Assertions.assertArrayEquals(
                    list.toTypedArray(), it.toMutableList().sorted().toTypedArray(),
                    """
                        method: $name
                        original: $it
                        result: $list
                    """.trimIndent()
                )
            }
        }

        testLists.forEach { testList ->
            testList(testList.map { it.toLong() }.toMutableList())
        }

        for (i in 0..4) {
            val newList = mutableListOf<Long>()

            for (j in 0..(Random.nextInt(50000))) {
                newList.add(Random.nextLong())
            }

            testList(newList)
        }

        for (i in 0..4) {
            val newList = mutableListOf<Long>()

            Random.nextBytes(Random.nextInt(50000)).forEach {
                newList.add(it.toLong())
            }

            testList(newList)
        }

        for ((name, durations) in times) {
            val sum = durations.sumOf { it.inWholeNanoseconds }.nanoseconds
            val avg = (sum.inWholeNanoseconds / durations.size).nanoseconds
            println("$name - avg: $avg - sum: $sum - $durations")
        }
    }
}

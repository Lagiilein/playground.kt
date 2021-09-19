package play

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import java.io.File
import java.util.Scanner

internal class MinimumAbsoluteDifferenceTest {

    @Test
    fun minimumAbsoluteDifference() {
        assertEquals(3, minimumAbsoluteDifference(arrayOf(3, -7, 0)))
        assertEquals(2, minimumAbsoluteDifference(arrayOf(-2, 2, 4)))
        assertEquals(1,
            minimumAbsoluteDifference(
                "-59 -36 -13 1 -53 -92 -2 -96 -54 75"
                    .split(' ')
                    .map { it.toInt() }
                    .toTypedArray()
            )
        )
        assertEquals(3, minimumAbsoluteDifference(arrayOf(1, -3, 71, 68, 17)))
    }

    @TestFactory
    fun `test minimumAbsoluteDifference with big inputs`(): Collection<DynamicTest> =
        listOf("/MinimumAbsoluteDifferenceTestValue1.txt", "/MinimumAbsoluteDifferenceTestValue2.txt")
            .map { filename ->
                return@map DynamicTest.dynamicTest("test from file \"$filename\"") {
                    val scanner = Scanner(File(MinimumLossTest::class.java.getResource(filename)!!.file))

                    val expectedValue = scanner.nextLine()!!.trim().toInt()
                    val inputValues = sequence {
                        while (scanner.hasNextInt()) {
                            yield(scanner.nextInt())
                        }
                    }

                    assertEquals(
                        expectedValue,
                        minimumAbsoluteDifference(
                            inputValues.toList().toTypedArray()
                        )
                    )
                }
            }
}

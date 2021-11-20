package com.github.lagiilein.playground.jvm

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.longs.shouldBeExactly
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import java.io.File
import java.util.Scanner

internal class CandiesTest : AnnotationSpec() {

    @org.junit.jupiter.api.Test
    fun `test candies() against precalculated solutions`() {
        candies(arrayOf(4, 6, 4, 5, 6, 2)) shouldBeExactly 10
        candies(arrayOf(1, 2, 2)) shouldBeExactly 4
        candies(arrayOf(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)) shouldBeExactly 19
        candies(arrayOf(2, 4, 3, 5, 2, 6, 4, 5)) shouldBeExactly 12

        candies(arrayOf(1, 2, 3, 4, 3, 2, 1)) shouldBeExactly listOf(1, 2, 3, 4, 3, 2, 1L).sum()
    }

    @TestFactory
    fun `test candies() against big inputs`(): Collection<DynamicTest> =
        listOf("/candy/01.txt")
            .map { filename ->
                return@map DynamicTest.dynamicTest("from $filename") {
                    val scanner = Scanner(File(CandiesTest::class.java.getResource(filename)!!.file))

                    val expectedResult = scanner.nextLine()!!.trim().toLong()
                    val inputValues = sequence {
                        while (scanner.hasNextLine()) {
                            yield(scanner.nextLine().toInt())
                        }
                    }

                    candies(inputValues.toList().toTypedArray()) shouldBeExactly expectedResult
                }
            }
}

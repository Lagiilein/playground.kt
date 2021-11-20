package com.github.lagiilein.playground.jvm

import com.github.lagiilein.playground.jvm.notelist.toSinglyLinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class AddTwoNumbersTest {

    @Test
    fun addTwoNumbers() {

        assertContentEquals(
            sequenceOf(7, 0, 8),
            addTwoNumbers(
                listOf(2, 4, 3).toSinglyLinkedList()!!,
                listOf(5, 6, 4).toSinglyLinkedList()!!
            ).asSequence()
        )

        assertContentEquals(
            sequenceOf(0),
            addTwoNumbers(
                listOf(0).toSinglyLinkedList()!!,
                listOf(0).toSinglyLinkedList()!!
            ).asSequence()
        )

        assertContentEquals(
            sequenceOf(8, 9, 9, 9, 0, 0, 0, 1),
            addTwoNumbers(
                listOf(9, 9, 9, 9, 9, 9, 9).toSinglyLinkedList()!!,
                listOf(9, 9, 9, 9).toSinglyLinkedList()!!
            ).asSequence()
        )
    }
}

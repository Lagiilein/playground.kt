package play.notelist

import org.junit.jupiter.api.Test
import java.util.UUID
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class ListNodeTest {
    @Test
    fun `test ListNode#asSequence() and ListNode#asList()`() {
        val n1 = ListNode(1)
        val n2 = ListNode(2)
        val n3 = ListNode(3)
        val n4 = ListNode(4)

        n1.next = n2
        n2.next = n3
        n3.next = n4

        assertContentEquals(
            sequenceOf(1, 2, 3, 4),
            n1.asSequence()
        )

        assertContentEquals(
            listOf(1, 2, 3, 4),
            n1.asList()
        )
    }

    @Test
    fun `test Collection#toSinglyLinkedList()`() {

        val lists = listOf(
            listOf(4, 3254, 6543, 124, 5643, 654),
            listOf("guehrgie", "fewf", "grehigehdfg3i5643t6gfd"),
            listOf(ListNode(534), UUID.randomUUID()),
            listOf(),
            setOf(52, -534, 535, 53496436, 434)
        )

        lists.forEach {
            val head = it.toSinglyLinkedList()

            if (it.isEmpty()) {
                assertEquals(null, head)
            } else {
                assertNotNull(head)

                assertContentEquals(
                    it,
                    head.asSequence().toList()
                )
            }
        }
    }
}

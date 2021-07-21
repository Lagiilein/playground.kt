package play.notelist

class ListNode<T>(var value: T) {
    var next: ListNode<T>? = null

    fun asSequence(): Sequence<T> = sequence {
        var cur: ListNode<T>? = this@ListNode

        while (cur != null) {
            yield(cur.value)
            cur = cur.next
        }
    }

    fun asList(): List<T> {
        val list = mutableListOf<T>()

        var cur: ListNode<T>? = this

        while (cur != null) {
            list.add(cur.value)
            cur = cur.next
        }

        return list.toList()
    }
}

fun <T> Collection<T>.toSinglyLinkedList(): ListNode<T>? = this.iterator().toSinglyLinkedList()

fun <T> Iterator<T>.toSinglyLinkedList(): ListNode<T>? {
    if (!this.hasNext()) return null

    val it = this.iterator()
    val head = ListNode(it.next())
    var cur = head

    while (it.hasNext()) {
        val next = ListNode(it.next())
        cur.next = next
        cur = next
    }

    return head
}

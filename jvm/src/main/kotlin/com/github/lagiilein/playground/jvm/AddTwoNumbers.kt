package com.github.lagiilein.playground.jvm

import com.github.lagiilein.playground.jvm.notelist.ListNode

/**
 * [https://leetcode.com/problems/add-two-numbers/]
 */
fun addTwoNumbers(l1: ListNode<Int>, l2: ListNode<Int>, radix: Int = 10): ListNode<Int> {
    var cur1 = l1.next
    var cur2 = l2.next

    val firstSum = l1.value + l2.value
    var carrier = firstSum / radix
    val sumHead = ListNode(firstSum % radix)
    var curSum = sumHead

    while (cur1 != null || cur2 != null) {

        val c1 = cur1?.value ?: 0
        val c2 = cur2?.value ?: 0

        val sum = c1 + c2 + carrier

        carrier = sum / radix
        val next = ListNode(sum % radix)
        curSum.next = next
        curSum = next
        cur1 = cur1?.next
        cur2 = cur2?.next
    }

    if (carrier != 0) {
        curSum.next = ListNode(carrier)
    }

    return sumHead
}

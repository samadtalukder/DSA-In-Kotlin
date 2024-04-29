package com.samad_talukder.data_structure.stacks

import com.samad_talukder.data_structure.linked_lists.SinglyNode
import java.util.*


data class ListNode(var `val`: Int, var next: ListNode? = null)

/**
 * Reverse a linked list
 *
 * @param stackLinkedList The linked list to be reversed.
 */
fun reverseLinkedList(stackLinkedList: LinkedList<Int>) {
    val sl = LinkedList<Int>()

    // Push elements from the input linked list to the new linked list
    for (node in stackLinkedList) {
        sl.push(node)
    }

    // Pop and print elements from the reversed linked list
    while (sl.isNotEmpty()) {
        val node = sl.pop()
        println(node)
    }
}

/**
 * Returns a new linked list containing elements in reverse order.
 *
 * @param stackLinkedList The linked list to be reversed.
 * @return A new linked list with elements in reverse order.
 */
fun returnReverseLinkedList(stackLinkedList: LinkedList<Int>): LinkedList<Int> {
    val reverseList = LinkedList<Int>()
    for (node in stackLinkedList) {
        reverseList.push(node)
    }
    return reverseList
}

fun reverseList(head: SinglyNode<Int>?): SinglyNode<Int>? {
    var prevHead: SinglyNode<Int>? = null
    var current = head

    while (current != null) {
        prevHead = SinglyNode(current.value).apply {
            next = prevHead
        }

        current = current.next
    }

    return prevHead
}

/**
 * Revers a LinkedList iteratively.
 *
 * @param head The head of the linked list to be reversed.
 * @return The head of the reversed linked list.
 */
fun reversListIterative(head: ListNode?): ListNode? {
    var prevHead: ListNode? = null
    var current = head

    while (current != null) {
        prevHead = ListNode(current.`val`).apply {
            next = prevHead
        }
        current = current.next
    }

    return prevHead
}

/**
 * Revers a LinkedList recursively.
 *
 * @param head The head of the linked list to be reversed.
 * @return The head of the reversed linked list.
 */
fun reversListRecursive(head: ListNode?): ListNode? {
    return reversLists(head, null)

}

/**
 * Helper function for reversing a linked list recursively.
 *
 * @param head The head of the current portion of the linked list to be reversed.
 * @param newHead The head of the reversed portion of the linked list.
 * @return The head of the reversed linked list.
 */
fun reversLists(head: ListNode?, newHead: ListNode?): ListNode? {
    if (head == null) return newHead
    val next = head.next
    head.next = newHead
    return reversLists(next, head)
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
    println()
}

fun <T : Any> LinkedList<T>.printReverse() {
    val stack = StackImpl<T>()

    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()

    while (node != null) {
        println(node)
        node = stack.pop()
    }
}


fun main() {
    val head = ListNode(1)

    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    printList(head)
    val rlist = reversListIterative(head)
    printList(rlist)

    val rv = reversListRecursive(head)
    printList(rv)

}
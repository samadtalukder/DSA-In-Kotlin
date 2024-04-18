package com.samad_talukder.data_structure.linked_lists


data class Node(val data: Int, var next: Node? = null)

class MyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null
    private var length = 0

    /**
     * Get the value of the index node in the linked list. If the index is invalid, return -1
     *
     * @param index
     * @return
     */
    fun get(index: Int): Int {
        return findAtIndex(index)?.data ?: -1
    }

    private fun findAtIndex(index: Int): Node? =
        when {
            index < 0 || index >= length -> null
            index == 0 -> head
            index == length - 1 -> tail
            else -> {
                var current = head
                repeat(index) {
                    current = current?.next
                }
                current
            }
        }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion,
     * the new node will be the first node of the linked list.
     *
     * @param value
     */
    fun addAtHead(value: Int) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }

        length++
    }

    /**
     * Append a node of value val as the last element of the linked list
     *
     * @param value
     */
    fun addAtTail(value: Int) {
        val newNode = Node(value)

        if (tail == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        length++
    }

    /**
     * Add a node of value val before the index node in the linked list.
     * If index equals the length of the linked list, the node will be appended to the end of the linked list.
     * If index is greater than the length, the node will not be inserted.
     *
     * @param index
     * @param value
     */
    fun addAtIndex(index: Int, value: Int) {
        if (index > length) return
        if (index == 0) {
            addAtHead(value)
            return
        }
        if (index == length) {
            addAtTail(value)
            return
        }

        val prev = findAtIndex(index - 1)

        val newNode = Node(value)
        newNode?.next = prev?.next
        prev?.next = newNode

        length++

    }

    /**
     * Delete the index node in the linked list, if the index is valid.
     *
     * @param index
     */
    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= length) return
        if (index == 0) {
            head = head?.next
            if (head == null) {
                tail = null
            }
            length--
            return
        }

        val prev = findAtIndex(index - 1)
        prev?.next = prev?.next?.next

        if (index == length - 1) {
            tail = prev
        }

        length--
    }
}


fun main() {
    val myLinkedList = MyLinkedList()

    myLinkedList.addAtHead(1)
    myLinkedList.addAtTail(3)
    myLinkedList.addAtIndex(1, 2)
    println(myLinkedList.get(1))
    myLinkedList.deleteAtIndex(1)
    println(myLinkedList.get(0))
}
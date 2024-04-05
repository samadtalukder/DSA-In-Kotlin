package com.samad_talukder.data_structure.linked_lists


class LinkedLists<T> {
    private var head: SinglyNode<T>? = null
    private var tail: SinglyNode<T>? = null
    private var size = 0

    /**
     * Check if the list is Empty
     * @return true if the list is Empty, else @return false
     */
    private fun isEmpty(): Boolean {
        return size == 0
    }

    /**
     * Pushes a new node with the value at the front of the list
     * @param value to be added
     */
    fun push(value: T) {
        head = SinglyNode(value = value, next = head)

        if (tail == null) {
            tail = head
        }

        size++
    }

    /**
     * Pushes a new node with the value at the front of the list
     * @param value to be added
     * @return the updated LinkedList
     */
    fun pushList(value: T): LinkedLists<T> {
        head = SinglyNode(value = value, next = head)

        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    /**
     * Append a new node with the value at the end of the list
     * @param value to be added
     */
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = SinglyNode(value = value)
        tail = tail?.next
        size++
    }

    /**
     * Append a new node with the value at the end of the list
     * @param value to be added
     * @return the updated LinkedList
     */
    fun appendList(value: T): LinkedLists<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = SinglyNode(value = value)
        tail = tail?.next
        size++
        return this
    }

    /**
     * Finding a particular node at the specified index in the list
     * @param index
     * @return the node at the specified index or null if the index is out of bounds
     */
    fun nodeAt(index: Int): SinglyNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    /**
     * Insert the new node with the given value after the specified node in the list
     * @param value to be added
     * @param afterNode the node after which the new node will be inserted
     * @return inserted node
     */
    fun insert(value: T, afterNode: SinglyNode<T>): SinglyNode<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = SinglyNode(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode
    }

    /**
     * Remove the value at the front of the list
     * @return the removed value or null if the list is empty
     */

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next

        if (isEmpty()) {
            tail = null
        }

        return result
    }

    /**
     * Removes the value at the end of the list
     * @return the removed value or null if the list is empty
     */
    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head

        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value
    }

    /**
     * Remove the value anywhere in the list
     * @param node whose next value will be removed
     * @return the removed value or null if there is no value after the specified value
     */
    fun removeAfter(node: SinglyNode<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }


}
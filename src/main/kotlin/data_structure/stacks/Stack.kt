package com.samad_talukder.data_structure.stacks

import java.util.LinkedList

interface Stack<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek(): Element?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0
}

class StackImpl<T : Any> : Stack<T> {
    private val storage = arrayListOf<T>()

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) return null
        return storage.removeAt(count - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

}

fun main() {
    val stack = StackImpl<Int>().apply {
        push(12)
        push(1)
        push(11)
        push(87)
    }
    println(stack)

    val poppedElement = stack.pop()
    if (poppedElement != null) {
        println("Popped: $poppedElement")
    }
    println(stack)

}
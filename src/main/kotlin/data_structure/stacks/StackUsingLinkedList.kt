package com.samad_talukder.data_structure.stacks

import java.util.LinkedList

fun main(){
    val stackLinkedList = LinkedList<Int>()

    val isEmpty = stackLinkedList.isEmpty()
    println("CheckIsEmpty: $isEmpty")

    stackLinkedList.apply {
        push(10)
        push(20)
        push(30)
        push(40)
    }
    println("StackPush: $stackLinkedList")

    val stackPop = stackLinkedList.pop()
    println("StackPop: $stackPop")

    val stackTop = stackLinkedList.peek()
    println("stackTop: $stackTop")

    val stackLastElement = stackLinkedList.last
    println("stackLastElement: $stackLastElement")

    val stackSize = stackLinkedList.size
    println("Size: $stackSize")

}
package com.samad_talukder.data_structure.stacks

fun main() {

    val stackDeque = ArrayDeque<Int>()

    stackDeque.addFirst(10)
    stackDeque.addFirst(20)
    stackDeque.addFirst(30)
    println("stackDeque: $stackDeque")

    val topElement = stackDeque.first()
    println("topElement: $topElement")

    val poppedElement = stackDeque.removeFirst()
    println("poppedElement: $poppedElement")

    val isEmpty = stackDeque.isEmpty()
    println("isEmpty: $isEmpty")

    stackDeque.addLast(50)
    println("stackAddLast: $stackDeque")

    val lastElement = stackDeque.last()
    println("lastElement: $lastElement")

    stackDeque[0] = 99
    println("stackSet: $stackDeque")
    println("stackGet: ${stackDeque[0]}")

    println("stackListSize: ${stackDeque.size}")

}
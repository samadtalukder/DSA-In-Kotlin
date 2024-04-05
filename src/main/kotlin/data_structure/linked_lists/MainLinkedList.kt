package com.samad_talukder.data_structure.linked_lists

fun main() {
    val lLists = LinkedLists<Int>()

    // Push operation
    lLists.push(32)
    lLists.push(82)
    lLists.push(99)
    lLists.push(10)

    println("Before list: $lLists")

    /*lLists.append(1)
    lLists.append(2)
    lLists.append(3)
    lLists.append(4)*/

    // lLists.pushList(1).pushList(2).pushList(3).pushList(4)
    // lLists.appendList(1).appendList(2).appendList(3).appendList(4)
    // println(lLists)

    // val midNode = lLists.nodeAt(2)!!
    // lLists.insert(3, midNode)

    //val poppedValue = lLists.pop()
    // val removeLastValue = lLists.removeLast()

    // val nodeIndex = lLists.nodeAt(1)!!
    // val removeFromTheIndex = lLists.removeAfter(nodeIndex)

    // println("After list: $lLists")
    // println("Popped Value: $poppedValue")
    // println("Remove Last Value: $removeLastValue")
    // println("Remove From The Index Value: $removeFromTheIndex")
}
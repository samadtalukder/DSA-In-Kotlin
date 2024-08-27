package com.samad_talukder.data_structure.arrays

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    val length = arr.size

    //traverseArrayForward(arr, length)
    traverseArrayForwardUsingForLoop(arr)
}

fun traverseArrayForward(arr: IntArray, length: Int) {
    println("length: $length")
    var i = 0
    while (i < length) {
        println("$i - ${arr[i]}")
        // move to the next index
        i += 1
    }
}

fun traverseArrayForwardUsingForLoop(arr: IntArray) {
    for (i in arr) {
        println("$i")
    }
}


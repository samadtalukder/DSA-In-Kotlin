package com.samad_talukder.data_structure.arrays

fun main() {
    val arr = intArrayOf(11, 22, 3, 4, 5)
    val length = arr.size

    //traverseArrayReverse(arr, length)
    traverseArrayBackward(arr, length)

}

fun traverseArrayReverse(arr: IntArray, length: Int) {
    println("length: $length")
    // Start from the last index an array
    var i = length - 1
    println("last index: $i")

    while (i >= 0) {
        println("$i - ${arr[i]}")
        // move to the next index
        i--
    }

}

fun traverseArrayBackward(arr: IntArray, length: Int) {
    for (i in length - 1 downTo 0) {
        println("${arr[i]}")
    }
}

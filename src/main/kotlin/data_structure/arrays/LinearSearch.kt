package com.samad_talukder.data_structure.arrays

fun main() {
    val arr = intArrayOf(1, 12, 43, 21, 40, 89, 39)
    val searchItem = 89
    val printIsFindTheItem = linearSearchUsingRecursive(arr, searchItem, 0)

    if (printIsFindTheItem != 0) {
        println("Result: $printIsFindTheItem")
    } else {
        println("Not Found")
    }

}

fun linearSearch(arr: IntArray, searchItem: Int): Int {
    for (i in arr) {
        if (i == searchItem) {
            return i
        }
    }
    return 0
}

fun linearSearchUsingRecursive(arr: IntArray, searchItem: Int, index: Int): Int {
    if (arr.size == index) {
        return 0
    } else if (arr[index] == searchItem) {
        return arr[index]
    }

    return linearSearchUsingRecursive(arr, searchItem, index + 1)
}

package com.samad_talukder.data_structure.arrays

/**
 * Given an array of integers, write a function to reverse the array in place. The function should modify the original
 * array so that the first element becomes the last, the second element becomes the second last, and so on.
 *
 * Example:
 *
 * Input: arr = [1, 2, 3, 4, 5]
 * Output: [5, 4, 3, 2, 1]
 *
 */

fun main() {
    val arr = intArrayOf(23, 12, 43, 64, 45)

    midPointApproach(arr)
    arr.forEach { println(it) }

    // iterativeApproach(arr)
    // arr.reverseInPlace()
    // findReverseArrayBuiltInFunctions(arr)
    // findReverseArray(arr)
    // recursiveApproach(arr, 0, arr.size - 1)
    // arr.forEach { println(it) }
}


/**
 * Reverses the elements of the input array in place using an iterative approach.
 * Modifies the original array, swapping elements from both ends moving toward the center.
 *
 * @param arr
 *
 * Time complexity: O(n) - where 'n' is the number of the elements in the array
 * Space complexity: O(1) - constant space is used
 *
 */

fun iterativeApproach(arr: IntArray) {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp

        left++
        right--
    }
    arr.forEach { print(" $it ") }
}

/**
 * Reverses the elements of the input array in place using a recursive approach.
 * Swap elements from both ends of the array moving toward the center using recursion
 *
 * @param arr
 * @param left (the starting index default is 0)
 * @param right (the ending index default is arr.size-1)
 *
 * Time complexity: O(n) - where 'n' is the number of the elements in the array
 * Space complexity: O(n) - due to recursive call back
 *
 */
fun recursiveApproach(arr: IntArray, left: Int, right: Int) {

    if (left >= right) return

    val temp = arr[left]
    arr[left] = arr[right]
    arr[right] = temp

    recursiveApproach(arr, left + 1, right - 1)
}


/**
 * Reverses the elements of the input array in place using a recursive approach.
 * Swap elements from both ends of the array moving toward the center using recursion
 *
 * Time complexity: O(n) - where 'n' is the number of the elements in the array. Each element swapped at once
 * Space complexity: O(n) - constant space is used as no additional space are created, and the operation is done in place
 *
 * @param arr
 */
fun midPointApproach(arr: IntArray) {
    val lastIndex = arr.size - 1
    val midPoint = (arr.size / 2) - 1

    if (arr.isEmpty()) {
        println("Empty Array")
        return
    }

    var reverseIndex = lastIndex
    var temp: Int

    for (index in 0..midPoint) {
        temp = arr[index]
        arr[index] = arr[reverseIndex]
        arr[reverseIndex] = temp

        reverseIndex--
    }
}

fun findReverseArrayBuiltInFunctions(arr: IntArray) {
    for (index in arr.size - 1 downTo 0) {
        println(arr[index])
    }
    // arr.reversedArray().forEach { println(it) }
    // println(arr.contentToString())
}




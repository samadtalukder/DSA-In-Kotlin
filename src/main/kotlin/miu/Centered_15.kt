package com.samad_talukder.miu

/**
 * An array is called centered-15 if some consecutive sequence of elements of the array sum to 15 and this sequence is
 * preceded and followed by the same number of elements.
 * For example {3, 2, 10, 4, 1, 6, 9} is centered-15 because the
 * sequence 10, 4, 1 sums to 15 and the sequence is preceded by two elements (3, 2) and followed by two elements(6,9).
 *
 * Write a method called isCentered15 that returns 1 if its array argument is centered- 15, otherwise it returns 0.
 *
 * Examples:
 * {3, 2, 10, 4, 1, 6, 9} return 1
 * {2, 10, 4, 1, 6, 9} return 0
 * {3, 2, 10, 4, 1, 6} return
 * {9, 15, 6} return 1
 * {1, 1, 2, 2, 1, 1} return 0
 * {1, 1, 15, -1,-1} return 1
 */
fun main() {
    val arr = intArrayOf(15, 0, 6, 9, 0, 0)

    println(isCentered1525(arr))


}

fun isCentered152(arr: IntArray): Int {
    val n = arr.size
    for (i in 0 until n) {
        val seq = arr.filterIndexed { index, _ -> index > i && index < n - i - 1 }
        if (seq.sumOf { it } == 15) {
            return 1
        }
    }
    return 0
}

fun isCentered1525(arr: IntArray): Int {
    val n = arr.size
    for (i in 0 until n) {
        var sum = 0
        for (j in i + 1 until n - i - 1) {
            sum += arr[j]
        }
        if (sum == 15) {
            return 1
        }
    }
    return 0
}

fun isCentered15(arr: IntArray): Int {
    val n = arr.size

    if (n == 0) return 0

    for (center in 0 until n) {
        var sum = arr[center]
        if (sum == 15) return 1
        for (radius in 1..minOf(center, n - center - 1)) {
            sum += arr[center - radius] + arr[center + radius]
            if (sum == 15) return 1
        }
    }
    return 0
}

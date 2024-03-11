package com.samad_talukder.leetcode

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

fun reverseString(s: CharArray) {
    var left = 0
    var right = s.size - 1

    while (left < right) {
        val temp = s[left]
        s[left] = s[right]
        s[right] = temp

        left++
        right--
    }

    print(s)
}

fun reverseString2(s: CharArray) {
    var start = 0
    var end = s.lastIndex

    while (start < end) {
        s[start] = s[end].also { s[end] = s[start] }

        start++
        end--
    }

    print(s)
}

fun main() {
    val strArr = charArrayOf('F', 'u', 't', 'u', 'r','e')
    //reverseString(strArr)
    reverseString2(strArr)

}

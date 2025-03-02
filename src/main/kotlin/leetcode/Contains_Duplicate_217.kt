package com.samad_talukder.leetcode

/**
 * Given an integer array nums return true if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 */

class Contains_Duplicate_217 {
    /**
     * Checks if the given array contains any duplicate elements.
     *
     * @param nums The input array of integers.
     * @return 'true' if duplicates exist, otherwise 'false'.
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()
        for (i in 1..<nums.size) {
            if (nums[i] == nums[i - 1]) {
                return true
            }
        }
        return false
    }

    /**
     * Checks if the given array contains any duplicate elements using a HashSet
     *
     * @param nums The input array of integers.
     * @return 'true' if duplicates exist, otherwise 'false'.
     */

    fun containsDuplicates(nums: IntArray): Boolean {
        val setNum = mutableSetOf<Int>()

        for (i in nums) {
            if (setNum.contains(i)) {
                return true
            }
            setNum.add(i)
        }

        return false
    }
}

fun main() {
    val containsDuplicate217 = Contains_Duplicate_217()

    val intArr = intArrayOf(1,1,2,1)

    println(containsDuplicate217.containsDuplicates(intArr))
}


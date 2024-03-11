package com.samad_talukder.leetcode

class Contains_Duplicate_217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()
        for (i in 1..<nums.size) {
            if (nums[i] == nums[i - 1]) {
                return true
            }
        }
        return false
    }

    fun containsDuplicateUsingSet(nums: IntArray): Boolean {
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

    val intArr = intArrayOf(1,2,3,4)
    //println("${intArr.sort()}")
    /*intArr.sort()

    for (i in 0..<intArr.size) {
        if (intArr[i] == intArr[i - 1]) {
            print(intArr[i])
        } else {
            print(intArr[i])
        }

    }*/
    println(containsDuplicate217.containsDuplicateUsingSet(intArr))
}


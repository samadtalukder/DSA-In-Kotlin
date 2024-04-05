package com.samad_talukder.others
/*
* You have been given a number 'N'. Your task is to find the sum of all even numbers
* from 1 to 'N' (both inclusive).
* Example :
* Given 'N' : 6
* Sum of all even numbers till 'N' will be : 2 + 4 + 6 = 12
*
* Sample Input 2 :
* 4
* 5
* 6
* Sample Output 2 :
* 6
* 6
* 12
* */
fun main() {

    val even = 9
    println(calculateEvenSum(even))
    //println(calculateEvenSumUsingWhile(even))
}

fun calculateEvenSum(even: Int): Int {
    return (2..even step 2).sum()
}

fun calculateEvenSumUsingWhile(even: Int): Int {
    var sum = 0
    var i = 2

    while (i <= even) {
        sum += i

        i += 2
    }

    return sum
}

package com.samad_talukder.data_structure.strings

import java.util.regex.Pattern

fun main() {
    val str = "wG"

    if (hasSpecialCharacter(str)) {
        println("has special character")
    } else {
        println("no special character")
    }


}

/**
 * Checks if the given string contains any special characters.
 *
 * @param str The input string to be checked for special characters.
 * @return True if the input string contains at least one special character, false otherwise.
 */
fun hasSpecialCharacter(str: String): Boolean {
    val pattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(str)

    return matcher.find()
}

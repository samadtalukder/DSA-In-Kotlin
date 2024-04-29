package com.samad_talukder.data_structure.strings

fun main() {
    val str = ".docx"

    println("getExtension: ${checkExtension(str)}")
}

/**
 * Checks the file extension of the given string.
 *
 * @param str The input string representing a file name or path.
 * @return The file extension if the input string is not null or empty and contains a valid extension,
 *          otherwise null is returned.
 */
fun checkExtension(str: String?): String? {
    if (str.isNullOrEmpty()) {
        return null
    }
    val lastIndex = str.lastIndexOf(".")
    return if (lastIndex > 0) {
        str.substring(lastIndex)
    } else {
        ""
    }

}

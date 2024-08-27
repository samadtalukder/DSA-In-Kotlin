package com.samad_talukder

fun main() {
    var name: String? = null
    showNameLength(name)
    println("Hello World!")
}

fun showNameLength(name: String?) { // Function accept nullable parameters
    println(if (name == null) 0 else name.length)
}

fun showNameLengthElvis(name: String?) { // Function accept nullable parameters
    println(name?.length ?: 0)
}

fun showNameLength2(name: String) { // Function accept only non-nullable parameters
    println(name.length)
}

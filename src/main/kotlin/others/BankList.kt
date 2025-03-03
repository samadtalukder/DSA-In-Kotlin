package com.samad_talukder.others

/**
 * Bank list
 */
val bankList = listOf(
    "AB Bank",
    "Bangladesh Bank",
    "Bangladesh Rural Development Bank",
    "UCB Bank",
    "",
    "Eastern Bank"
)

fun main() {
    //optimizedBankTitleFirstLetter()
    //createAlphabetTitleHeader()
    getBankNameByFirstLetter()
}

/**
 * Organizes and displays banks by their starting letter.
 *
 * This function groups banks from [bankList] by their first letter,
 * then iterate through the alphabet [A-Z] and displays all banks that start with each letter.
 * Only letters that have at least one matching bank will be shown in the output
 *
 */
fun optimizedBankTitleFirstLetter() {
    val bankFirstLetter = bankList.groupBy { it.first() }

    for (i in 'A'..'Z') {
        bankFirstLetter[i]?.let { title ->
            println("$i -> ${title.joinToString(",")}")
        }
    }
}

/**
 * Organizes and displays banks by their starting letter.
 *
 * This function groups banks from [bankList] by their first letter,
 * then iterate through the alphabet [A-Z] and displays all banks that start with each letter.
 * Only letters that have at least one matching bank will be shown in the output
 *
 */
fun getBankTitleFirstLetterUsingFilter() {
    for (bankTitle in 'A'..'Z') {
        val bankHeader = bankList.filter { it.first() == bankTitle }
        if (bankHeader.isNotEmpty()) {
            println("$bankTitle -> ${bankHeader.joinToString(", ")}")
        }
    }
}

/**
 * Organizes and displays banks by their starting letter.
 *
 * This function groups banks from [bankList] by their first letter,
 * then iterate through the alphabet [A-Z] and displays all banks that start with each letter.
 * Only letters that have at least one matching bank will be shown in the output
 *
 */
fun getBankNameByFirstLetter() {
    val bankName = bankList.filter { it.isNotEmpty() }.groupBy { it.first() }
    for ((letter, bankList) in bankName) {
        println("$letter -> ${bankList.joinToString(", ")}")
    }
}

/**
 * Create alphabet title header
 *
 */
fun createAlphabetTitleHeader() {
    for (bankTitle in 'A'..'Z') {
        val bankHeader: List<String> = getBankTitleWithLetter(bankTitle)
        if (bankHeader.isNotEmpty()) {
            println("BankTitle: $bankTitle, $bankHeader")
        }
    }
}

/**
 * Checking if the first character of each bank names matches the specified character.
 *
 * @param bankTitle
 * @return
 */
fun getBankTitleWithLetter(bankTitle: Char): List<String> {
    val bankHeader = mutableListOf<String>()
    for (b in bankList) {
        if (b[0] == bankTitle) {
            bankHeader.add(b)
        }
    }

    return bankHeader
}


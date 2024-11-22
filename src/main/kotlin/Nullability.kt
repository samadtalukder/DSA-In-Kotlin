package com.samad_talukder

import java.util.*

data class AccountOverview(
    val productType: String?,
    val toAccountOverview: ToAccountOverview?,
)

data class ToAccountOverview(
    val accountNumber: Int,
    val accountName: String?,
    val currencyCode: String?,
)

enum class APIStatus(val statusCode: Int?) {
    SUCCESS(statusCode = 200),
    FAILED(null),
    LOADING(statusCode = 100)
}

sealed class Result {
    data class SUCCESS(val data: String?) : Result()
    data class FAILED(val errorMessage: Int?) : Result()
    data object LOADING : Result()
}

fun main() {
    handleNestedNullableString()

    handleNullWithException()

    handleNullableStringList()

    handleStringLengthNull()

    handleNullAccessWithFallback()

    handleNullWithLet()

    handleNullWithLet()

    handleIsNullOrEmptyString()

    handleNonNullValue()

    handleAPIStatusValue()

    handleSealedStatusValue()

}

fun handleAPIStatusValue() {
    println(getStatusMsg(APIStatus.LOADING))
    println(getStatusMsg(null))
    println(getStatusMsg(APIStatus.SUCCESS))
    println(getStatusMsg(APIStatus.FAILED))
}

fun handleSealedStatusValue() {
    println(getSealedStatusMsg(Result.LOADING))
    println(getSealedStatusMsg(Result.SUCCESS("Data")))
    println(getSealedStatusMsg(null))
    println(getSealedStatusMsg(Result.FAILED(501)))

}

fun getStatusMsg(apiStatus: APIStatus?): String {
    return when (apiStatus?.statusCode) {
        200 -> "Success"
        null -> "Error with null"
        else -> "${apiStatus.statusCode}"
    }
}

fun getSealedStatusMsg(result: Result?): String {
    return when (result) {
        is Result.SUCCESS -> result.data ?: "No Data Found"
        is Result.FAILED -> "Failed to connect"
        is Result.LOADING -> "Loading"
        null -> "Found Null"
    }
}

fun handleNonNullValue() {

    println(returnNonNullValue(null))
    println(returnNonNullValue(1))
    println(returnNonNullValue("01"))
}

fun returnNonNullValue(value: Any?): Any {
    return value ?: 0
}

fun handleIsNullOrEmptyString() {
    val station: String? = ""
    val location: String? = null

    println(station.isNullOrEmpty())
    println(location.isNullOrEmpty())
}

fun handleNullWithLet() {
    val name: String? = null
    name?.let {
        println("Your Name: $it")
    } ?: println("Please Enter Your Name")
}

fun handleNullAccessWithFallback() {
    val amount: Int? = null
    val result = try {
        amount!!
    } catch (e: Exception) {
        -1
    }
    println(result)
}

fun handleStringLengthNull() {
    printLength("Song")
    printLength(null)
}

fun printLength(data: String?) {
    println("Length: ${data?.length}")
}

fun handleNullableStringList() {
    val items: List<String?> = listOf("Adventure", "Horror", null, "Action", null)
    items.forEach { println(it?.uppercase(Locale.getDefault()) ?: "No Data") }
}

fun handleNullWithException() {
    val message: String? = null
    try {
        val msgLength = message?.length
        println("Message length: $msgLength")

        val length = message?.length ?: throw IllegalStateException("Message is null")
        println("Message length: $length")
    } catch (e: Exception) {
        println(e.message)
    }
}

fun handleNestedNullableString() {
    val accountOverview: AccountOverview? = AccountOverview(
        "Savings",
        ToAccountOverview(0, null, "")
    )

    val accLength = accountOverview?.toAccountOverview?.accountName ?: -1
    println(accLength)
}


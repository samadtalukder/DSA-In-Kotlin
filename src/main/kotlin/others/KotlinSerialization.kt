package com.samad_talukder.others

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

/**
 * MobileDeveloper data class with properties annotated for JSON serialization
 *
 * @property platformName
 * @property language
 * @property appStoreName
 * @constructor Create empty Mobile developer
 */

@Serializable
data class MobileDeveloper(
    @SerialName("platform") val platformName: String,
    @SerialName("lang") val language: String,
    @SerialName("app_store") val appStoreName: String?,
)

/**
 * Demonstrates serialization and deserialization of a kotlin data class using kotlinx serialization.
 * Serializes the object to JSON
 * Deserializes to the JSON into an object
 *
 */
fun main() {
    val anDev = MobileDeveloper("Android", "Kotlin", null)
    // Serialize to JSON
    val json = Json.encodeToJsonElement(anDev)
    val jsonString = Json.encodeToString(anDev)

    // Deserialize JSON into object
    val deserialize = Json.decodeFromJsonElement<MobileDeveloper>(json)

    println(anDev)
    println("Serialize: $json")
    println("SerializeString: $jsonString")
    println("Deserialize: $deserialize")
    println("Deserialize: ${deserialize.appStoreName ?: "No Store"}")
}



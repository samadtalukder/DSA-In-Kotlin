package com.samad_talukder.others

open class MilesToKmConverter {
    open fun milesToKmFactor(): Double {
        return 1.609
    }

    fun milesToKm(miles: Double): Double {
        return this.milesToKmFactor() * miles
    }
}

class NauticalMilesToKmConverter : MilesToKmConverter() {
    override fun milesToKmFactor(): Double {
        return 1.852
    }
}

fun main() {
    val nauticalMiles = NauticalMilesToKmConverter()
    val milesToKmConverter = MilesToKmConverter()
    val test = (NauticalMilesToKmConverter() as MilesToKmConverter).milesToKm(1.0)

    println(nauticalMiles.milesToKm(1.0))
    println(test)
}
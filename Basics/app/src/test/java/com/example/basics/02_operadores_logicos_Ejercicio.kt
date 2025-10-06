package com.example.basics

fun main() {
    println("Evaluación de Apto Físico")

    val edad: Int = 20
    val tieneEntrenamiento: Boolean = false
    val nivel: Int = 4
    val esApto = edad >= 18 && tieneEntrenamiento && nivel >= 5
    val necesitaAyuda = !tieneEntrenamiento || nivel < 3

    println("Edad: $edad")
    println("Tiene entrenamiento: $tieneEntrenamiento")
    println("Nivel: $nivel")
    println("Es apto: $esApto")
    println("Necesita ayuda: $necesitaAyuda")
}
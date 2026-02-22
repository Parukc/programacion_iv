package com.example.basics

fun main() {
    println("Bucles en la Fórmula 1")

    val pilotos = listOf("Hamilton", "Verstappen", "Leclerc", "Norris", "Alonso")

    println("Lista de pilotos en la parrilla:")
    for ((index, piloto) in pilotos.withIndex()) {
        println("${index + 1}. $piloto")
    }

    println("Monitoreando combustible:")
    for (i in 0..100 step 25) {
        println("Combustible restante: $i%")
    }

    println("Cuenta regresiva de inicio de carrera:")
    for (countdown in 5 downTo 1) {
        println("La carrera inicia en: $countdown...")
    }
    println("¡Y arrancan los motores!")


    println("Verificando autos en pits:")
    for (piloto in pilotos) {
        if (piloto == "Leclerc") continue
        if (piloto == "Alonso") break
        println("Auto de $piloto listo para continuar")
    }

    println("Fin del simulador de bucles de F1")
}

package com.example.basics.tarea

fun main() {
    print("Distancia km: ")
    val km = readln().toDouble()
    print("¿Llueve? sí-no: ")
    val llueve = readln().lowercase()

    val base = when {
        km <= 5 -> 2.5
        km in 6.0..15.0 -> 5.0
        else -> 8.0
    }

    val total = if (llueve == "sí") base + 1.5 else base
    println("Costo total: $total USD")
}

package com.example.basics.tarea

import kotlin.random.Random

fun main() {
    print("Número de etapas: ")
    val etapas = readln().toInt()
    var energia = 100

    for (i in 1..etapas) {
        val terreno = Random.nextInt(1, 4)
        energia -= when (terreno) {
            1 -> 5   // Asfalto
            2 -> 10  // Tierra
            else -> 15 // Barro
        }

        if (energia <= 0) {
            println("Abandona en etapa $i")
            return
        } else {
            println("Etapa $i completada. Energía restante: $energia")
        }
    }

    println("Rally completado con energía final: $energia")
}

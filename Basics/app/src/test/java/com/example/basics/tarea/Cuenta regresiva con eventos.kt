package com.example.basics.tarea

fun main() {
    for (i in 30 downTo 0) {
        when (i) {
            20 -> println("Chequeo de sistemas")
            10 -> println("Últimos ajustes")
            0 -> println("Despegue!")
            else -> println(i)
        }
    }
}

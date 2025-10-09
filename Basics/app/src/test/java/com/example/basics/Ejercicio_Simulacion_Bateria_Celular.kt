package com.example.basics

fun main() {

    println("Monitoreando bateria:")
    for (i in 100 downTo 0 step 10) {
        when (i) {
            100 -> println("Carga al $i% Bateria Completa")
            50 -> println("Carga al $i% Bateria Mitad")
            0 -> println("Carga al $i% Bateria Descargada")
            else -> println("Carga al $i%")
        }
    }
}
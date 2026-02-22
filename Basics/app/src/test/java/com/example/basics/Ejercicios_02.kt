package com.example.basics

fun main(){
    println("Ingresa la hora de clase")
    val hora: Int = readLine()?.toIntOrNull()?:0
    when{
        hora >= 7 && hora <= 13 -> print("Clase en la mañana")
        hora >= 14 && hora <= 19 -> print("Clase en la tarde")
        else->print("horario lectivo")
    }
}




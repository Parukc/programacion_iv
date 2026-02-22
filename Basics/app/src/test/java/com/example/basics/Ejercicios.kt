package com.example.basics

fun main(){
    println("Ingresa tu nota")
    val promedio: Int = readLine()?.toIntOrNull()?:0
    println("Trabajas: si o no")
    val trabajo: String = readLine()?.lowercase()?: "no"
    when{
        promedio >= 90 && trabajo == "no" -> print("Beca completa")
        promedio >= 90 && trabajo == "si" -> print("Beca parcial")
        promedio < 90 -> print("Sin beca")
        else->print("Sin beca")
    }
}




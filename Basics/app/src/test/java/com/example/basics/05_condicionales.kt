package com.example.basics

fun main(){
    println("!Estructuras de control!!!")
    println("!Condicionales!!!")
    val value1 = 10
    val value2 = 15
    if (value1>value2){
        println("El mayor es ${value1}" )
    } else {
        println("El mayor es ${value2}" )
    }
    println("Rango segun nivel de la fuerza")
    var fuerza: Int = 10
    if (fuerza > 10){
        println("Maestro" )
    } else if (fuerza > 5){
        println("Caballero Jedi" )
    } else {
        println("Padawan" )
    }
    modelo: String = "R2-D2"
    when(modelo: String)
    }
}
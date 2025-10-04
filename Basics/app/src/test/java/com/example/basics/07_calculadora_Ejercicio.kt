package com.example.basics

fun main(){
    println("!Calculadora")
    println("Incluir primer valor")
    val value1: Int = readLine()?.toIntOrNull()?:0
    println("Incluir segundo valor")
    val value2: Int = readLine()?.toIntOrNull()?:0
    println("Colcoar la Operacion + , - , * , /")
    val signo: String? = readLine()
    when(signo){
    "+" -> print("Suma : ${value1 + value2}")
    "-" ->print("Resta : ${value1 - value2}")
    "*" ->print("Multiplicacion : ${value1 * value2}")
    "/" ->print("Division : ${value1 / value2}")
        else -> print("Operacion Desconocida")
    }
}


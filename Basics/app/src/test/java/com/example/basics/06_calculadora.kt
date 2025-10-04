package com.example.basics

fun main(){
    println("!Calculadora")
    println("Incluir primer valor")
    val value1: Int = readLine()?.toIntOrNull()?:0
    println("Incluir segundo valor")
    val value2: Int = readLine()?.toIntOrNull()?:0
    print("Suma : ${value1 + value2}")
    print("Resta : ${value1 - value2}")
    print("Multiplicacion : ${value1 * value2}")
    print("Division : ${value1 / value2}")
}


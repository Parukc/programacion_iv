package com.example.basics.tarea

fun main() {
    print("Ingresa un texto: ")
    val texto = readln()
    var contador = 0

    for (i in 0 until texto.length - 1) {
        val par = texto.substring(i, i + 2)
        if (par[0].lowercaseChar() in "aeiou" && par[1].lowercaseChar() in "aeiou") {
            contador++
        }
    }

    println("Número de vocales consecutivas: $contador")
}

package com.example.basics

fun main() {
    println("!Estructuras de control!!!")
    println("!Condicionales!!!")
    val value1 = 10
    val value2 = 15
    if (value1 > value2) {
        println("El mayor es ${value1}")
    } else {
        println("El mayor es ${value2}")
    }
    println("Rango segun nivel de la fuerza")
    var fuerza: Int = 10
    if (fuerza > 10) {
        println("Maestro")
    } else if (fuerza > 5) {
        println("Caballero Jedi")
    } else {
        println("Padawan")
    }

    var tipoDroide: String = "BB-8"
    when(tipoDroide){
    "R2-D2", "R2-Q5" -> print("Droide astromecanico")
    "C-3P0", "C-3pa" -> print("Droide de protocolo")
    "B8-8", "BB-9E" -> print("Droide de nueva generacion")
    else -> print("Modelo Desconocido")
    }

    var peligro: Int = 10
    var recompensa: Int = 50
    when{
        peligro>8 && recompensa < 1000 -> print("Droide astromecanico")
        peligro<=3 ->print("Mision Aceptada")
        else -> print("Reqioere Evaluacion adicional")
    }

    var color: String = "rojo"
    var estado_calle: String = ""
    when{
        color == "verde" -> print("Avanzar")
        color == "amarillo" && estado_calle == "vacia" -> print("Precaucion")
        color == "amarillo" && estado_calle == "trafico" -> print("Esperar")
        color == "rojo" -> print("Esperar")
        else->print("Desconocido")
    }

    var mes: String = "Abril"
    when(mes){
        "Marzo", "Julio", "Noviembre" -> print("Fuego")
        "Abril", "Agosto", "Diciembre" -> print("Tierra")
        "Mayo", "Septiembre", "Enero" -> print("Aire")
        "Junio", "Octubre", "Febrero" -> print("Agua")
        else -> print("Signo Desconocido")
    }
}
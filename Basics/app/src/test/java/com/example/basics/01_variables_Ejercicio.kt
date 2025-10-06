package com.example.basics

fun main(){
    println("VARIABLES")
    val auto = "Ferrari"
    var piloto = "Verstappen"

    piloto = "Norris"
    println("Tipos de Variables")
    println("Tipos Numèricos")
    println("Tipo Entero")
    val edad: Int = 21
    println(edad)

    println("Tipo Double")
    val altura: Double = 30.5
    println(altura)

    println("Tipo Float")
    val peso: Float = 30.5f
    println(peso)

    println("Tipo Long")
    val poblacion: Long = 3_000_000_000L
    println(poblacion)

    println("Tipo Texto")
    val nombre: String = "Charles Lecrerc"
    println(nombre)

    println("Tipo Char")
    val incial: Char = '0'
    println(incial)

    println("Tipo Lògico")
    val esPiloto: Boolean = true
    println(esPiloto)

    println("Nulaidad")
    val apellido: String? = "Piastri"
    println(apellido)

    println("Nulaidad")
    val ciudad: String? = ""
    println(ciudad?.length)

    println("Operacion de asercion no null")
    val longitudSegura = apellido!!.length

    println("Interpolacion de strings")
    val nombrePiloto: String = "Sena"
    val edadPiloto: Int = 23
    val autoPiloto: String = "Williams"

    println("${nombrePiloto.uppercase()} nacio en ${autoPiloto}")
    println("En 10 anioss tendra: ${edadPiloto+10} anios")

    println("String Multilinea")
    val mensaje: String = """
        Querido: $nombre
        Tu vehiculo es el $auto
        ah sido completada existosamente
     """.trimIndent()
    println(mensaje)

    println("Conversiones")
    val textoEdad: String = "25"
    val edadConvertida: Int = textoEdad.toInt()
    println(edadConvertida)

    val numero: Double = 50.8
    val numeroConvertido: String = numero.toString()
    println(numeroConvertido)
}
package com.example.basics

data class Sacramento(
    val nombre: String,
    val edadMinima: Int,
    val tipo: String,  // Iniciación, Sanación, Servicio
    val requiereGuia: Boolean = false
) {
    val categoria: String
        get() = when (tipo) {
            "Iniciación" -> "Primeros pasos en la fe"
            "Sanación" -> "Fortalece el espíritu"
            "Servicio" -> "Compromiso con la comunidad"
            else -> "Otro"
        }

    fun puedeRecibirse(edadPersona: Int): Boolean = edadPersona >= edadMinima

    fun requiereAcompanamiento(): Boolean = requiereGuia
}

fun main() {
    val bautismo = Sacramento(
        nombre = "Bautismo",
        edadMinima = 0,
        tipo = "Iniciación",
        requiereGuia = true
    )

    println(bautismo)

    val (nombre, edadMinima, tipo) = bautismo
    println("Sacramento: $nombre, Edad mínima: $edadMinima, Tipo: $tipo")

    val matrimonio = bautismo.copy(
        nombre = "Matrimonio",
        edadMinima = 18,
        tipo = "Servicio",
        requiereGuia = true
    )
    println(matrimonio)

    println("Categoría del matrimonio: ${matrimonio.categoria}")

    println("¿Puede recibirse el matrimonio a los 20 años?: ${matrimonio.puedeRecibirse(20)}")
    println("¿Requiere acompañamiento espiritual?: ${matrimonio.requiereAcompanamiento()}")

    val eucaristia = Sacramento("Eucaristía", 9, "Iniciación")
    println("Sacramento: ${eucaristia.nombre}, Categoría: ${eucaristia.categoria}")
    println("¿Un niño de 7 años puede recibirlo?: ${eucaristia.puedeRecibirse(7)}")
}

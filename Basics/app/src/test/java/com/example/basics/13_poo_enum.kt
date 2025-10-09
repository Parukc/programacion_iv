package com.example.basics

enum class TipoSable(val color: String, val poder: Int) {
    AZUL(color = "azul", poder = 85) {
        override fun description() = "Sable tradicional de los Jedi"
    },
    VERDE(color = "verde", poder = 90) {
        override fun description() = "Sable de los Jedi consulares"
    },
    ROJO(color = "rojo", poder = 95) {
        override fun description() = "Sable de los Sith"
    },
    MORADO(color = "morado", poder = 95) {
        override fun description() = "Sable que equilibra luz y oscuridad"
    };

    abstract fun description(): String

    companion object {
        fun porColor(color: String) = values().find { it.color == color }
    }
}

class SableDeLuz(val tipo: TipoSable, val portador: String) {
    fun activar() = "!ZZZrum! El sable color ${tipo.color} de $portador se enciende"
    fun info() = "${tipo.description()} - poder ${tipo.poder}"
}

fun main() {
    val sableWindoo = SableDeLuz(TipoSable.MORADO, portador = "Windoo")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())

    val sableLuke = SableDeLuz(TipoSable.VERDE, portador = "Luke Skywalker")
    println(sableLuke)
    println(sableWindoo.activar())
    println(sableWindoo.info())
}

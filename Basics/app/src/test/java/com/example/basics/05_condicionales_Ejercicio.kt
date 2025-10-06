package com.example.basics

fun main() {
    println("Bienvenido al Simulador de Fórmula 1")


    println("Tiempos de vuelta:")
    val tiempoHamilton = 78.5
    val tiempoVerstappen = 77.9

    if (tiempoHamilton < tiempoVerstappen) {
        println("Hamilton hizo la vuelta más rápida: ${tiempoHamilton}s")
    } else {
        println("Verstappen hizo la vuelta más rápida: ${tiempoVerstappen}s")
    }

    println(" Clasificación de piloto:")
    val puntos = 180

    if (puntos > 200) {
        println("Nivel: Leyenda ")
    } else if (puntos >= 100) {
        println("Nivel: Profesional ")
    } else {
        println("Nivel: Novato ")
    }

    println(" Escudería y su nacionalidad:")
    val escuderia = "Ferrari"

    when (escuderia) {
        "Ferrari", "AlphaTauri" -> println("🇮🇹 Escudería italiana")
        "Red Bull", "Mercedes" -> println("🇩🇪 Escudería alemana")
        "McLaren" -> println("🇬🇧 Escudería británica")
        else -> println("Escudería internacional")
    }

    println(" Evaluación de riesgo en pista:")
    val clima = "lluvia"
    val velocidadPromedio = 310

    when {
        clima == "lluvia" && velocidadPromedio > 300 -> println("Riesgo alto: posible accidente")
        clima == "soleado" && velocidadPromedio <= 280 -> println("Condiciones seguras")
        else -> println("Precaución: revisar neumáticos y visibilidad")
    }

    println("Semáforo de inicio:")
    val colorSemaforo = "verde"

    when (colorSemaforo) {
        "rojo" -> println("Detente, aún no inicia la carrera")
        "amarillo" -> println("Prepárate... casi arranca")
        "verde" -> println("¡Arranca la carrera! ")
        else -> println("Estado desconocido del semáforo")
    }


    println("Circuito y su tipo:")
    val circuito = "Mónaco"

    when (circuito) {
        "Mónaco", "Singapur" -> println("$circuito → Circuito urbano")
        "Silverstone", "Spa" -> println("$circuito → Circuito tradicional")
        "Yas Marina" -> println("$circuito → Circuito nocturno")
        else -> println("$circuito → Tipo de circuito desconocido")
    }

    println("Fin del simulador de Fórmula 1")
}

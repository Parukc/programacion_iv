package com.example.basics

// Función simple sin parámetros
fun presentarSacramentos() {
    println("Bienvenido a los 7 Sacramentos de la Iglesia Católica")
}

fun contarSacramentos(recibidos: Int, faltantes: Int): Int {
    return recibidos + faltantes
}

fun sacramentosRestantes(total: Int, recibidos: Int) = total - recibidos

fun resumenSacramentos(recibidos: Int, faltantes: Int): Pair<Int, String> {
    val total = recibidos + faltantes
    val mensaje = if (recibidos == total) {
        "Has recibido todos los sacramentos. ¡Felicidades!"
    } else {
        "Aún te faltan $faltantes sacramentos por recibir."
    }
    return Pair(total, mensaje)
}

fun main() {
    presentarSacramentos()

    // Ejemplo de uso de funciones
    val recibidos = 3
    val faltantes = 4

    val total = contarSacramentos(recibidos, faltantes)
    println("Total de sacramentos: $total")

    println("Sacramentos restantes por recibir: ${sacramentosRestantes(total, recibidos)}")

    val resumen = resumenSacramentos(recibidos, faltantes)
    println("Resumen: Total = ${resumen.first}, Mensaje = ${resumen.second}")

    val bendecir = { nombre: String -> "Que Dios te bendiga, $nombre 🙏" }
    val duplicarSacramentos = { n: Int -> n * 2 }

    println(bendecir("Carlos"))
    println("Si duplicaras tu fe, alcanzarías ${duplicarSacramentos(recibidos)} bendiciones.")

    val mostrarSacramento = { nombre: String, tipo: String ->
        "El sacramento de $nombre pertenece al tipo $tipo"
    }

    println(mostrarSacramento("Bautismo", "Iniciación"))
}

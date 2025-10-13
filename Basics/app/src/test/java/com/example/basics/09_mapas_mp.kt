package com.example.basics

fun main() {
    println("LOS 7 SACRAMENTOS DE LA IGLESIA CATÓLICA")

    val sacramentos = mapOf(
        "Bautismo" to "Iniciación",
        "Confirmación" to "Iniciación",
        "Eucaristía" to "Iniciación",
        "Penitencia" to "Sanación",
        "Unción de los enfermos" to "Sanación",
        "Orden sacerdotal" to "Servicio a la comunidad",
        "Matrimonio" to "Servicio a la comunidad"
    )
    println("\nSacramentos y su tipo: $sacramentos")

    val edadesRecomendadas = mutableMapOf<String, Int>()
    edadesRecomendadas["Bautismo"] = 0
    edadesRecomendadas["Confirmación"] = 15
    edadesRecomendadas["Eucaristía"] = 9
    edadesRecomendadas["Matrimonio"] = 25
    println("\nEdades recomendadas: $edadesRecomendadas")

    // Recorrer mapa
    println("\nListado de sacramentos:")
    for ((nombre, tipo) in sacramentos) {
        println("- $nombre pertenece al tipo $tipo")
    }

    val sacramentosIniciacion = setOf("Bautismo", "Confirmación", "Eucaristía")
    val sacramentosSanacion = setOf("Penitencia", "Unción de los enfermos")
    val sacramentosServicio = setOf("Orden sacerdotal", "Matrimonio")

    println("\n=== Operaciones con conjuntos ===")
    val todos = sacramentosIniciacion union sacramentosSanacion union sacramentosServicio
    val comunes = sacramentosIniciacion intersect sacramentosServicio
    val noIncluidos = sacramentosIniciacion - sacramentosSanacion

    println("Todos los sacramentos: $todos")
    println("Sacramentos comunes entre iniciación y servicio: $comunes")
    println("Sacramentos de iniciación que no son de sanación: $noIncluidos")

    println("\n=== Fin del programa ===")
}

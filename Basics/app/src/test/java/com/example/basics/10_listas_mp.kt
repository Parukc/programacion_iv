package com.example.basics

fun main(){
    println("LISTAS DE LOS 7 SACRAMENTOS")

    val sacramentosInmutables: List<String> = listOf(
        "Bautismo",
        "Confirmación",
        "Eucaristía",
        "Penitencia",
        "Unción de los enfermos",
        "Orden sacerdotal",
        "Matrimonio"
    )
    println("Lista inmutable de sacramentos: $sacramentosInmutables")

    val sacramentosPendientes: MutableList<String> = mutableListOf(
        "Bautismo", "Confirmación", "Eucaristía"
    )
    println("\nLista mutable inicial: $sacramentosPendientes")

    sacramentosPendientes.add("Penitencia")
    println("Después de agregar Penitencia: $sacramentosPendientes")

    sacramentosPendientes.removeAt(0)
    println("Después de eliminar el primer sacramento: $sacramentosPendientes")

    println("\nSacramentos pendientes de recibir:")
    for (sacramento in sacramentosPendientes) println("- $sacramento")

    println("\n=== Operaciones con Mutable List ===")

    val tipos = mutableListOf("Iniciación", "Sanación")
    tipos.add("Servicio")
    tipos += "Vocacional"
    tipos.add(index = 1, element = "Fe")
    println("Tipos de sacramentos: $tipos")

    tipos.remove("Sanación")
    println("Después de remover 'Sanación': $tipos")

    tipos.removeAt(0)
    println("Después de eliminar el primer elemento: $tipos")

    tipos[0] = "Compromiso"
    println("Reemplazo de elemento: $tipos")

    tipos.clear()
    println("¿Lista vacía?: ${tipos.isEmpty()}")

    println("\n=== Búsquedas en lista de sacramentos ===")

    val nombresSacramentos = mutableListOf("Bautismo", "Confirmación", "Eucaristía", "Matrimonio")
    println("Primer sacramento que empieza con 'C': ${nombresSacramentos.find { it.startsWith('C') }}")
    println("Primer sacramento con más de 10 letras: ${nombresSacramentos.firstOrNull { it.length > 10 }}")
    println("¿Alguno contiene la letra 'M'?: ${nombresSacramentos.any { it.contains('M') }}")
    println("¿Ninguno se llama 'Confesión'?: ${nombresSacramentos.none { it == "Confesión" }}")

    println("\n=== Ordenamiento de listas ===")

    val edadesRecomendadas = mutableListOf(0, 15, 9, 25, 18, 30, 10)
    println("Edades recomendadas (ascendente): ${edadesRecomendadas.sorted()}")
    println("Edades recomendadas (descendente): ${edadesRecomendadas.sortedDescending()}")
    println("Edades sin repetir: ${edadesRecomendadas.distinct()}")

    println("\n=== Fin del programa ===")
}

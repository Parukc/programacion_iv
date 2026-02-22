package com.example.basics

fun main(){
    println("Mapas")

    val fuerzaJedis = mapOf(
        "Luke" to 85,
        "leia" to 80,
        "Obi-Wan" to 95,
        "Yoda" to 100
    )
    println("Fuerza de los Jedis : ${fuerzaJedis}")

    println("Mapa Mutable")

    val misionesCompletadas = mutableMapOf<String, Int>()
    misionesCompletadas ["Luke"] = 15
    misionesCompletadas ["leia"] = 12
    misionesCompletadas.put ("Han", 20)

    println("Misiones : ${misionesCompletadas}")

    for((jedi, fuerza) in fuerzaJedis){
        println("$jedi tiene nivel de fuerza $fuerza")
    }

    val planetasVisitados = setOf("Tatooine", "Coruscant", "Dagobah")
    println("Planetas Visitados : ${planetasVisitados}")

    val planetasPeligrosos = setOf("Musfarar", "Coruscant", "Korriban")
    println("Planetas Peligrosos : ${planetasPeligrosos}")

    println("Operaciones de Conjuntos")
    val interseccion = planetasPeligrosos intersect planetasVisitados
    val union = planetasPeligrosos union planetasVisitados
    val diferencia = planetasPeligrosos - planetasVisitados
    println("Planetas visitas y peligrosos : ${interseccion}")
    println("Todos los Planetas : ${union}")
    println("Planetas Seguros visitados : ${diferencia}")
}







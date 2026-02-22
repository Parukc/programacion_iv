package com.example.basics

fun saludar(){
    println("Hola desde una funcion de Kotlin")
}

//funcion con parametros y retorno
fun sumar(a: Int, b: Int): Int{
    return a + b
}

//Funcion con expresion single.expression function
fun cuadrado(numero: Int) = numero * numero
//Funcion con retorno multiple
fun retornoMultople(a: Int, b: Int): Pair<Int,Int> {
    val suma = a + b
    val resta = a - b
    return Pair(suma, resta)
}

    fun main(){
        saludar()
        val resultado = sumar(5, 6)
        println(resultado)
        println(cuadrado(5))
        println(retornoMultople(15,5))
        //Funcion Lamba
        val cuadradoLamda = {x: Int-> x*x}
        val saludoLamda = {nombre: String-> "Good Morning, $nombre"}
        println(cuadradoLamda(4))
        println(saludoLamda("Juan Luis Guerra"))
}


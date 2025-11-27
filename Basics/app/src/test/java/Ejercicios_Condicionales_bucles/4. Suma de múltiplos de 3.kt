package Ejercicios_Condicionales_bucles

fun main() {
    print("Ingresa N: ")
    val n = readln().toInt()
    var suma = 0
    for (i in 1..n) {
        if (i % 3 == 0) suma += i
    }
    println("Suma de múltiplos de 3 hasta $n: $suma")
}

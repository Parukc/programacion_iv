package Ejercicios_Condicionales_bucles

fun main() {
    print("Número: ")
    val n = readln().toInt()
    for (i in 1..10) {
        println("$n x $i = ${n * i}")
    }
}

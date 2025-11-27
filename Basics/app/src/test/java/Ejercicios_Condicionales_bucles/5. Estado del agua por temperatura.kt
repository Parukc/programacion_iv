package Ejercicios_Condicionales_bucles

fun main() {
    print("Temperatura en °C: ")
    val t = readln().toDouble()

    when {
        t <= 0 -> println("Sólido")
        t in 1.0..99.0 -> println("Líquido")
        else -> println("Gas")
    }
}

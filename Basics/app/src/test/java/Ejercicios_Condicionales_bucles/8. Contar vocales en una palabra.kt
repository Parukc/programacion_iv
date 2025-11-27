package Ejercicios_Condicionales_bucles

fun main() {
    print("Ingresa texto: ")
    val texto = readln().lowercase()
    val vocales = "aeiou"
    val conteo = texto.count { it in vocales }
    println("Cantidad de vocales: $conteo")
}

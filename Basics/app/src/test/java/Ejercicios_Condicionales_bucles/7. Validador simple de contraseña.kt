package Ejercicios_Condicionales_bucles

fun main() {
    print("Contraseña: ")
    val pass = readln()
    val tieneDigito = pass.any { it.isDigit() }

    if (pass.length >= 8 && tieneDigito)
        println("Contraseña válida")
    else
        println("Contraseña inválida")
}

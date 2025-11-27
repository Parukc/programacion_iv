package Ejercicios_Condicionales_bucles

fun main() {
    var resultado = 0.0

    while (true) {
        println("\n1) Sumar  2) Restar  3) Salir")
        print("Opción: ")
        when (readln()) {
            "1" -> {
                print("Número: ")
                val num = readln().toDouble()
                resultado += num
                println("Resultado: $resultado")
            }
            "2" -> {
                print("Número: ")
                val num = readln().toDouble()
                resultado -= num
                println("Resultado: $resultado")
            }
            "3" -> {
                println("Resultado final: $resultado")
                break
            }
            else -> println("Opción inválida")
        }
    }
}

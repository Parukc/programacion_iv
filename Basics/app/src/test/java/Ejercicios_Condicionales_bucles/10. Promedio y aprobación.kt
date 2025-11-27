package Ejercicios_Condicionales_bucles

fun main() {
    print("Nota 1: ")
    val n1 = readln().toDouble()
    print("Nota 2: ")
    val n2 = readln().toDouble()
    print("Nota 3: ")
    val n3 = readln().toDouble()

    val promedio = (n1 + n2 + n3) / 3
    val estado = if (promedio >= 14) "Aprobado" else "Reprobado"
    println("Promedio: %.2f → %s".format(promedio, estado))
}

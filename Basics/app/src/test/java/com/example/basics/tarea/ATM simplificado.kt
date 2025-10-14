package com.example.basics.tarea

fun main() {
    var saldo = 100.0
    var opcion: Int

    do {
        println("1) Depositar  2) Retirar  3) Salir")
        print("Elige una opción: ")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                print("Monto a depositar: ")
                saldo += readln().toDouble()
            }
            2 -> {
                print("Monto a retirar: ")
                val retiro = readln().toDouble()
                if (retiro > saldo) println("Saldo insuficiente")
                else saldo -= retiro
            }
        }
        println("Saldo actual: $$saldo")
    } while (opcion != 3)

    println("Sesión terminada.")
}

package com.example.basics.tarea

fun main() {
    var totalDia = 0.0
    var clientes = 0

    while (true) {
        print("Nuevo cliente (total o 'fin'): ")
        val entrada = readln().lowercase()
        if (entrada == "fin") break

        val total = entrada.toDouble()
        print("¿Cuántos ítems lleva?: ")
        val items = readln().toInt()

        var totalCliente = if (total > 100) total * 0.95 else total
        if (items > 10) println("Caja rápida no disponible")
        println("Total del cliente: $$totalCliente\n")

        totalDia += totalCliente
        clientes++
    }

    println("Total vendido: $$totalDia")
    println("Clientes atendidos: $clientes")
}

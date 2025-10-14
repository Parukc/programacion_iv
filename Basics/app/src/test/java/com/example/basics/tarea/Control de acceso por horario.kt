package com.example.basics.tarea

fun main() {
    print("Hora actual (0–23): ")
    val hora = readln().toInt()
    print("Rol (admin/invitado/empleado): ")
    val rol = readln().lowercase()

    val acceso = when (rol) {
        "admin" -> true
        "invitado" -> hora in 9..17
        "empleado" -> hora in 6..20
        else -> false
    }

    println(if (acceso) "Acceso permitido" else "Acceso denegado")
}

package com.example.basics

fun main() {
    println("=== Sacramento de la Penitencia (Ejemplo con Try–Catch) ===")

    try {
        println("Intentando dividir tus faltas entre tus buenas acciones...")
        val buenasAcciones = 0
        val resultado = 7 / buenasAcciones
        println("Balance espiritual: $resultado")
    } catch (e: Exception) {
        println("😇 Se ha producido un error espiritual: ${e.message}")
        println("Reflexión: Nadie puede dividir entre el bien y el mal sin la ayuda del perdón.")
        println("Consejo: Acude al sacramento de la *Penitencia* para reconciliarte con Dios.")
    } finally {
        println("🙏 Fin del proceso. La fe y la reflexión siempre deben acompañar tus decisiones.")
    }
}

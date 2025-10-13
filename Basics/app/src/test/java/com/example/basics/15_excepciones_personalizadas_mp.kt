package com.example.basics

import java.lang.Exception

class FeInsuficienteException(message: String) : Exception(message)
class PreparacionIncompletaException(nivelPreparacion: Int, message: String) : Exception(message)

fun recibirSacramento(nivelFe: Int, nivelPreparacion: Int): String {
    return try {
        when {
            nivelFe < 30 -> throw FeInsuficienteException("Fe demasiado débil: $nivelFe%")
            nivelPreparacion < 70 -> throw PreparacionIncompletaException(nivelPreparacion, "Preparación espiritual insuficiente")
            else -> "✅ Sacramento recibido con éxito. ¡Dios te bendiga!"
        }
    } catch (e: FeInsuficienteException) {
        "⚠️ Error: ${e.message}. Se recomienda fortalecer la fe con oración y acompañamiento."
    } catch (e: PreparacionIncompletaException) {
        "⚠️ Error: ${e.message}. Nivel de preparación: ${nivelPreparacion}%. Participa en la catequesis antes de recibir el sacramento."
    } catch (e: Exception) {
        "❌ Error inesperado: ${e.message}"
    } finally {
        "🙏 Registro espiritual enviado a la parroquia."
    }
}

fun main() {
    println(recibirSacramento(nivelFe = 20, nivelPreparacion = 80))
    println(recibirSacramento(nivelFe = 85, nivelPreparacion = 60))
    println(recibirSacramento(nivelFe = 90, nivelPreparacion = 90))
}

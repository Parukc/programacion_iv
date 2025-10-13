package com.example.basics

enum class TipoSacramento(val categoria: String, val compromiso: Int) {
    BAUTISMO(categoria = "Iniciación", compromiso = 60) {
        override fun descripcion() = "Marca el comienzo de la vida cristiana y limpia el pecado original."
    },
    CONFIRMACION(categoria = "Iniciación", compromiso = 80) {
        override fun descripcion() = "Fortalece la fe y otorga el don del Espíritu Santo."
    },
    EUCARISTIA(categoria = "Iniciación", compromiso = 85) {
        override fun descripcion() = "Alimenta el alma con el Cuerpo y la Sangre de Cristo."
    },
    PENITENCIA(categoria = "Sanación", compromiso = 70) {
        override fun descripcion() = "Restaura la gracia mediante el perdón de los pecados."
    },
    UNCION_ENFERMOS(categoria = "Sanación", compromiso = 75) {
        override fun descripcion() = "Da fortaleza y consuelo espiritual en momentos de enfermedad o sufrimiento."
    },
    ORDEN_SACERDOTAL(categoria = "Servicio", compromiso = 95) {
        override fun descripcion() = "Consagra a los ministros que servirán a la comunidad cristiana."
    },
    MATRIMONIO(categoria = "Servicio", compromiso = 90) {
        override fun descripcion() = "Une a dos personas en amor y fidelidad bajo la bendición de Dios."
    };

    abstract fun descripcion(): String

    companion object {
        fun porCategoria(categoria: String) = values().filter { it.categoria == categoria }
    }
}

class SacramentoRecibido(val tipo: TipoSacramento, val persona: String) {
    fun celebrar() = "🎉 ¡El sacramento de ${tipo.name.lowercase().replace('_', ' ')} ha sido celebrado por $persona!"
    fun info() = "${tipo.descripcion()} (Categoría: ${tipo.categoria}, Nivel de compromiso: ${tipo.compromiso})"
}

fun main() {
    val sacramento1 = SacramentoRecibido(TipoSacramento.BAUTISMO, persona = "Carlos Sánchez")
    println(sacramento1)
    println(sacramento1.celebrar())
    println(sacramento1.info())

    val sacramento2 = SacramentoRecibido(TipoSacramento.MATRIMONIO, persona = "María y José")
    println(sacramento2)
    println(sacramento2.celebrar())
    println(sacramento2.info())

    println("\nSacramentos de Iniciación disponibles:")
    val iniciacion = TipoSacramento.porCategoria("Iniciación")
    iniciacion.forEach { println("- ${it.name}: ${it.descripcion()}") }
}

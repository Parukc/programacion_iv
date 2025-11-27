fun main() {
    fun leerNota(idx: Int): Double {
        print("Nota $idx (0-20): ")
        return (readln().toDoubleOrNull() ?: 0.0).coerceIn(0.0, 20.0)
    }

    val n1 = leerNota(1)
    val n2 = leerNota(2)
    val n3 = leerNota(3)

    val prom = (n1 + n2 + n3) / 3.0
    val estado = if (prom >= 14.0) "Aprobado" else "Reprobado"

    println("Promedio: ${"%.2f".format(prom)} -> $estado")
}


package Ejercicios_Condicionales_bucles


fun main(){
 print("Coloca tu edad")
 val edad = readln().toInt()
    val precio = when {
        edad < 12 -> 3
        edad >= 65 -> 4
        else -> 5
    }
    println("El precio de entrada: $$precio")
}


package Ejercicios_Condicionales_bucles

fun main(){
    print("Color del semaforo")
    val color = readln().lowercase()
    print("Presiono el boton si/no")
    val boton = readln().lowercase()

    when {
        color == "verde" && boton == "si" -> println("Espera a Rojo")
        color == "rojo" && boton == "no" -> println("Cruza")
        color == "amarillo" && boton == "no" -> println("Preparate")
        else -> println("Espera")
    }
}
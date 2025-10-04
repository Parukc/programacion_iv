package com.example.basics

fun main(){
    println("Bucles")
    val jedis = listOf("Luke","Leia","Obi-Wan","Yoda","Ahsoka")
    for((index,jedi) in jedis.withIndex()){
        println("${index+1}.$jedi")
    }

    //rangos de paso
    for (i in 0 .. 20 step 5){
        println("Energia: $i%")
    }

    // rangos decendente
    for (countdown in 10 downTo 1){
        println("Despliegue en: $countdown")
    }
    // Control de flujo
    for (jedi in jedis){
        if(jedi == "Obi-Wan") continue // saltar esta Interaccion
        if(jedi == "Yoda") break // saltar esta Interaccion
        println("entrenando a $jedi")
    }
    }



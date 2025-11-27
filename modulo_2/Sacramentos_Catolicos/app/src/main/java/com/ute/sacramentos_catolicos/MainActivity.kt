package com.example.sacramentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SacramentosApp()
        }
    }
}

// Datos de cada sacramento
data class Sacramento(
    val nombre: String,
    val tipo: String,    // Iniciación, Sanación, Servicio a la comunidad
    val descripcion: String
)

@Composable
fun SacramentosApp() {
    val sacramentos = listOf(
        Sacramento(
            "Bautismo",
            "Sacramento de Iniciación",
            "Es el primer sacramento y nos hace hijos de Dios, miembros de la Iglesia y borra el pecado original."
        ),
        Sacramento(
            "Confirmación",
            "Sacramento de Iniciación",
            "Fortalece la gracia del bautismo y nos da los dones del Espíritu Santo para ser testigos de la fe."
        ),
        Sacramento(
            "Eucaristía",
            "Sacramento de Iniciación",
            "Jesús se hace presente bajo las especies de pan y vino. Es el centro y culmen de la vida cristiana."
        ),
        Sacramento(
            "Penitencia o Reconciliación",
            "Sacramento de Sanación",
            "Por medio de la confesión de los pecados, recibimos el perdón de Dios y nos reconciliamos con Él y con la Iglesia."
        ),
        Sacramento(
            "Unción de los Enfermos",
            "Sacramento de Sanación",
            "Se administra a los enfermos para darles consuelo, paz, fortaleza y, si Dios lo quiere, la recuperación de la salud."
        ),
        Sacramento(
            "Orden Sacerdotal",
            "Sacramento de Servicio a la Comunidad",
            "Configura al hombre con Cristo Sacerdote para servir al pueblo de Dios como diácono, presbítero o obispo."
        ),
        Sacramento(
            "Matrimonio",
            "Sacramento de Servicio a la Comunidad",
            "Une en alianza sagrada a un hombre y una mujer para formar una comunidad de vida y amor abierta a la familia."
        )
    )

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Text(
                    text = "Los 7 Sacramentos",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Aplicación educativa sobre los sacramentos de la Iglesia Católica.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(sacramentos) { sacramento ->
                        SacramentoCard(sacramento)
                    }
                }
            }
        }
    }
}

@Composable
fun SacramentoCard(sacramento: Sacramento) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = sacramento.nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = sacramento.tipo,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = sacramento.descripcion,
                fontSize = 14.sp
            )
        }
    }
}

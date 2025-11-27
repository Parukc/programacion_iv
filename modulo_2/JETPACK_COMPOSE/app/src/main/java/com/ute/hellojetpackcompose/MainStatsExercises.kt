package com.ute.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class StatsScreen(val route: String) {
    object Home : StatsScreen("stats_home")
    object Grades : StatsScreen("grades")
    object Savings : StatsScreen("savings")
    object Operations : StatsScreen("operations")
}

class MainStatsExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { StatsNavApp() }
    }
}

@Composable
fun StatsNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = nav,
                startDestination = StatsScreen.Home.route
            ) {
                composable(StatsScreen.Home.route) { StatsHomeScreen(nav) }
                composable(StatsScreen.Grades.route) { GradesScreen(nav) }
                composable(StatsScreen.Savings.route) { SavingsScreen(nav) }
                composable(StatsScreen.Operations.route) { OperationsScreen(nav) }
            }
        }
    }
}

@Composable
fun StatsHomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ejercicios simples de estadisticas",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Grades.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Notas Promedio")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Savings.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Plan de ahorro")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Operations.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Operaciones Básicas")
        }
    }
}

@Composable
fun GradesScreen(nav: NavController) {
    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }

    val average = statsAverage(grade1, grade2, grade3)
    val message = when {
        average == 0.0 -> "Ingresa notas validas"
        average >= 9.0 -> "Excelente"
        average >= 7.0 -> "Bueno"
        average >= 5.0 -> "Necesita Mejorar"
        else -> "Reprobado"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Notas Promedio",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Nota 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Nota 2") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Nota 3") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Promedio = ${"%.2f".format(average)}")
        Text(message)

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}

@Composable
fun SavingsScreen(nav: NavController) {
    var goal by remember { mutableStateOf("") }
    var perMonth by remember { mutableStateOf("") }

    val months = savingMonths(goal, perMonth)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Plan de Ahorro",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = goal,
            onValueChange = { goal = it },
            label = { Text("Monto Objetivo ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = perMonth,
            onValueChange = { perMonth = it },
            label = { Text("Ahorro por mes ($)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Meses necesarios = ${"%.1f".format(months)}")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}

@Composable
fun OperationsScreen(nav: NavController) {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }

    val ops = basicOperations(num1, num2)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Operaciones Básicas",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Numero 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Numero 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("${num1.ifBlank { "0" }} + ${num2.ifBlank { "0" }} = ${"%.2f".format(ops.sum)}")
        Text("${num1.ifBlank { "0" }} - ${num2.ifBlank { "0" }} = ${"%.2f".format(ops.sub)}")
        Text("${num1.ifBlank { "0" }} * ${num2.ifBlank { "0" }} = ${"%.2f".format(ops.mul)}")
        Text("${num1.ifBlank { "0" }} / ${num2.ifBlank { "0" }} = ${"%.2f".format(ops.div)}")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}

fun statsAverage(g1: String, g2: String, g3: String): Double {
    val n1 = g1.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n2 = g2.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n3 = g3.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (n1 == 0.0 && n2 == 0.0 && n3 == 0.0) return 0.0
    return (n1 + n2 + n3) / 3.0
}

fun savingMonths(goal: String, perMonth: String): Double {
    val g = goal.replace(",", ".").toDoubleOrNull() ?: 0.0
    val m = perMonth.replace(",", ".").toDoubleOrNull() ?: 0.0
    if (g <= 0.0 || m <= 0.0) return 0.0
    return g / m
}

data class OperationsResult(
    val sum: Double,
    val sub: Double,
    val mul: Double,
    val div: Double
)

fun basicOperations(a: String, b: String): OperationsResult {
    val n1 = a.replace(",", ".").toDoubleOrNull() ?: 0.0
    val n2 = b.replace(",", ".").toDoubleOrNull() ?: 0.0

    val sum = n1 + n2
    val sub = n1 - n2
    val mul = n1 * n2
    val div = if (n2 != 0.0) n1 / n2 else 0.0

    return OperationsResult(sum, sub, mul, div)
}

@Preview(showBackground = true)
@Composable
fun PreviewStatsNav() {
    StatsNavApp()
}

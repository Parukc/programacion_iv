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

// ---------------- RUTAS ----------------
sealed class StatsScreen(val route: String) {
    object Home : StatsScreen("stats_home")
    object Grades : StatsScreen("grades")
    object Savings : StatsScreen("savings")
    object Operations : StatsScreen("operations")
    object Salary : StatsScreen("salary")
}

// ---------------- ACTIVITY PRINCIPAL ----------------
class MainStatsExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { StatsNavApp() }
    }
}

// ---------------- NAV HOST ----------------
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
                composable(StatsScreen.Salary.route) { SalaryScreen(nav) }
            }
        }
    }
}

// ---------------- HOME ----------------
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
            text = "Simple Stats Exercises",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Grades.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Grades Average")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Savings.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Savings Planner")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Operations.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Basic Operations + - * /")
        }
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = { nav.navigate(StatsScreen.Salary.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salary Calculator")
        }
    }
}

// ---------------- GRADES ----------------
@Composable
fun GradesScreen(nav: NavController) {
    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }

    val average = statsAverage(grade1, grade2, grade3)
    val message = when {
        average == 0.0 -> "Enter valid grades"
        average >= 9.0 -> "Excellent"
        average >= 7.0 -> "Good"
        average >= 5.0 -> "Needs improvement"
        else -> "Failed"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Grades Average",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Grade 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Grade 2") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Grade 3") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Average = ${"%.2f".format(average)}")
        Text(message)

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

// ---------------- SAVINGS ----------------
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
            text = "Savings Planner",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = goal,
            onValueChange = { goal = it },
            label = { Text("Goal amount ($)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = perMonth,
            onValueChange = { perMonth = it },
            label = { Text("Save per month ($)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Months needed = ${"%.1f".format(months)}")

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

// ---------------- OPERATIONS + - * / ----------------
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
            text = "Basic Operations",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Number 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Number 2") },
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
            Text("Back")
        }
    }
}

// ---------------- SALARY ----------------
@Composable
fun SalaryScreen(nav: NavController) {
    var baseSalary by remember { mutableStateOf("") }
    var overtime by remember { mutableStateOf("") }
    var bonuses by remember { mutableStateOf("") }
    var iess by remember { mutableStateOf("") }
    var privateInsurance by remember { mutableStateOf("") }
    var incomeTax by remember { mutableStateOf("") }

    val salaryResult = salaryCalculation(
        baseSalary,
        overtime,
        bonuses,
        iess,
        privateInsurance,
        incomeTax
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Salary Calculator",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        // Ingresos
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Income", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = baseSalary,
                    onValueChange = { baseSalary = it },
                    label = { Text("Base salary ($)") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = overtime,
                    onValueChange = { overtime = it },
                    label = { Text("Overtime ($)") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = bonuses,
                    onValueChange = { bonuses = it },
                    label = { Text("Bonuses ($)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Text("Total income = ${"%.2f".format(salaryResult.totalIncome)} $")
            }
        }

        // Descuentos
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Deductions", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = iess,
                    onValueChange = { iess = it },
                    label = { Text("IESS ($)") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = privateInsurance,
                    onValueChange = { privateInsurance = it },
                    label = { Text("Private insurance ($)") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = incomeTax,
                    onValueChange = { incomeTax = it },
                    label = { Text("Income tax ($)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Text("Total deductions = ${"%.2f".format(salaryResult.totalDeductions)} $")
            }
        }

        // Resultado
        Text(
            text = "Net salary = ${"%.2f".format(salaryResult.netSalary)} $",
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = { nav.navigateUp() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

// ---------------- FUNCIONES LÓGICAS ----------------
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

data class SalaryResult(
    val totalIncome: Double,
    val totalDeductions: Double,
    val netSalary: Double
)

fun salaryCalculation(
    baseSalary: String,
    overtime: String,
    bonuses: String,
    iess: String,
    privateInsurance: String,
    incomeTax: String
): SalaryResult {
    val base = baseSalary.replace(",", ".").toDoubleOrNull() ?: 0.0
    val extra = overtime.replace(",", ".").toDoubleOrNull() ?: 0.0
    val bonus = bonuses.replace(",", ".").toDoubleOrNull() ?: 0.0

    val iessVal = iess.replace(",", ".").toDoubleOrNull() ?: 0.0
    val privIns = privateInsurance.replace(",", ".").toDoubleOrNull() ?: 0.0
    val tax = incomeTax.replace(",", ".").toDoubleOrNull() ?: 0.0

    val totalIncome = base + extra + bonus
    val totalDeductions = iessVal + privIns + tax
    val net = totalIncome - totalDeductions

    return SalaryResult(totalIncome, totalDeductions, net)
}

// ---------------- PREVIEW ----------------
@Preview(showBackground = true)
@Composable
fun PreviewStatsNav() {
    StatsNavApp()
}

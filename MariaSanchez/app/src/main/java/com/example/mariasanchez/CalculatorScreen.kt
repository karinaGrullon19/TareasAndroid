package com.example.mariasanchez

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.text.KeyboardOptions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen() {

    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun calcular() {
        val n1 = num1.toDoubleOrNull()
        val n2 = num2.toDoubleOrNull()

        result = if (n1 != null && n2 != null) {
            "Resultado: ${n1 * n2}"
        } else {
            "Ingresa números válidos"
        }
    }

    fun borrar() {
        num1 = ""
        num2 = ""
        result = ""
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calculadora") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = num1,
                onValueChange = { num1 = it },
                label = { Text("Número 1") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = num2,
                onValueChange = { num2 = it },
                label = { Text("Número 2") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Button(
                    onClick = { calcular() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Multiplicar")
                }

                Button(
                    onClick = { borrar() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Borrar")
                }
            }

            if (result.isNotEmpty()) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = result,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}
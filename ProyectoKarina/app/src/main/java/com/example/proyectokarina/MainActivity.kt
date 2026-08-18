package com.example.proyectokarina

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Enlazamos los componentes del XML con Kotlin
        val etNumero1 = findViewById<EditText>(R.id.etNumero1)
        val etNumero2 = findViewById<EditText>(R.id.etNumero2)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // 2. Programamos la acción del botón
        btnMultiplicar.setOnClickListener {
            val texto1 = etNumero1.text.toString()
            val texto2 = etNumero2.text.toString()

            // Validamos que los campos no estén vacíos
            if (texto1.isNotEmpty() && texto2.isNotEmpty()) {
                val n1 = texto1.toDouble()
                val n2 = texto2.toDouble()

                val operacion = n1 * n2

                // Mostramos el resultado de forma limpia
                tvResultado.text = "Resultado: $operacion"
            } else {
                // Alerta flotante si falta algún dato
                Toast.makeText(this, "Por favor, llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.example.tarea2radio

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupEquipos)
        val btnSeleccionar = findViewById<Button>(R.id.btnSeleccionar)

        btnSeleccionar.setOnClickListener {

            val seleccionado = radioGroup.checkedRadioButtonId

            if (seleccionado == -1) {
                Toast.makeText(this, "Seleccione un equipo", Toast.LENGTH_SHORT).show()
            } else {
                val radioButton = findViewById<RadioButton>(seleccionado)
                Toast.makeText(
                    this,
                    "Equipo seleccionado: ${radioButton.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
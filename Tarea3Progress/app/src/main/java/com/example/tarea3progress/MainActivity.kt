package com.example.tarea3progress

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var txtPorcentaje: TextView
    private lateinit var btnIniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        txtPorcentaje = findViewById(R.id.txtPorcentaje)
        btnIniciar = findViewById(R.id.btnIniciar)

        btnIniciar.setOnClickListener {
            iniciarCarga()
        }
    }

    private fun iniciarCarga() {

        btnIniciar.isEnabled = false

        val handler = Handler(Looper.getMainLooper())
        var progreso = 0

        handler.post(object : Runnable {
            override fun run() {

                if (progreso <= 100) {

                    progressBar.progress = progreso
                    txtPorcentaje.text = "$progreso%"

                    progreso += 10

                    handler.postDelayed(this, 300)

                } else {

                    txtPorcentaje.text = "Carga completada ✅"
                    btnIniciar.isEnabled = true
                }
            }
        })
    }
}
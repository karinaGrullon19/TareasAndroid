package com.example.tarea7constraintlogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etCorreo: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        etCorreo = findViewById(R.id.etCorreo)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val correo = etCorreo.text.toString()
            val password = etPassword.text.toString()

            if (correo.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Complete todos los campos",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Login correcto",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

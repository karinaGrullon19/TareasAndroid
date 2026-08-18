package com.example.tarea4login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtUsuario: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUsuario = findViewById(R.id.edtUsuario)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val usuario = edtUsuario.text.toString()
            val password = edtPassword.text.toString()

            if (usuario.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Complete todos los campos",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Inicio de sesión correcto",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

package com.example.tarea8activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        etNombre = findViewById(R.id.etNombre)
        btnEnviar = findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener {

            val nombre = etNombre.text.toString()

            val intent = Intent()
            intent.putExtra("nombre", nombre)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
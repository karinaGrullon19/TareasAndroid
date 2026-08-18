package com.example.tarea8activityresult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnAbrir: Button

    private val resultado =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {

                val nombre = result.data?.getStringExtra("nombre")

                Toast.makeText(
                    this,
                    "Hola $nombre",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnAbrir = findViewById(R.id.btnAbrir)

        btnAbrir.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)

            resultado.launch(intent)
        }
    }
}
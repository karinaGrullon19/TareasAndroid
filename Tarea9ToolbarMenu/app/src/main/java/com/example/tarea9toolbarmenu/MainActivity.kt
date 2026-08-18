package com.example.tarea9toolbarmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_opciones, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.opcion_inicio -> {
                Toast.makeText(
                    this,
                    "Seleccionaste Inicio",
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.opcion_perfil -> {
                Toast.makeText(
                    this,
                    "Seleccionaste Perfil",
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.opcion_configuracion -> {
                Toast.makeText(
                    this,
                    "Seleccionaste Configuración",
                    Toast.LENGTH_SHORT
                ).show()
            }

            android.R.id.home -> {
                Toast.makeText(
                    this,
                    "Botón de navegación",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
package com.example.tareakotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("T1", "Proyecto funcionando")

        val nombre = "Karina"
        Log.d("T1", "Hola $nombre")
    }
}

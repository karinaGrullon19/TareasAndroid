package com.example.sistemafacturacion

import android.app.Application
import androidx.room.Room
import com.example.sistemafacturacion.database.FacturacionDatabase

class FacturacionApp : Application() {

    companion object {
        lateinit var database: FacturacionDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            FacturacionDatabase::class.java,
            "facturacion-db"
        ).build()
    }
}
package com.example.sistemafacturacion.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        ClienteEntity::class,
        ProductoEntity::class,
        FacturaEntity::class
    ],
    version = 1
)
abstract class FacturacionDatabase : RoomDatabase() {

    abstract fun facturacionDao(): FacturacionDao
}
package com.example.sistemafacturacion.database

import androidx.room.*

@Dao
interface FacturacionDao {

    // Consultas de Productos
    @Query("SELECT * FROM producto_entity WHERE idProducto = :id")
    fun getProductoById(id: Int): ProductoEntity?
    @Query("SELECT * FROM producto_entity")
    fun obtenerTodosLosProductos(): List<ProductoEntity>

    @Insert
    fun insertProducto(producto: ProductoEntity): Long

    // Consultas de Clientes
    @Query("SELECT * FROM cliente_entity WHERE rncCedula = :rnc")
    fun getClienteByRnc(rnc: String): ClienteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCliente(cliente: ClienteEntity)

    // Registrar Factura
    @Insert
    fun insertFactura(factura: FacturaEntity): Long

    @Update
    fun updateProducto(producto: ProductoEntity)
}
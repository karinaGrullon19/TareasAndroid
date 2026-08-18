package com.example.sistemafacturacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sistemafacturacion.database.ProductoEntity

class InventarioActivity : AppCompatActivity() {

    private lateinit var editNombreProducto: EditText
    private lateinit var editPrecioProducto: EditText
    private lateinit var editStockProducto: EditText
    private lateinit var btnRegistrarProducto: Button
    private lateinit var textInventario: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventario)

        editNombreProducto = findViewById(R.id.editNombreProducto)
        editPrecioProducto = findViewById(R.id.editPrecioProducto)
        editStockProducto = findViewById(R.id.editStockProducto)
        btnRegistrarProducto = findViewById(R.id.btnRegistrarProducto)
        textInventario = findViewById(R.id.textInventario)

        mostrarInventario()

        btnRegistrarProducto.setOnClickListener {
            registrarProducto()
        }
    }

    private fun registrarProducto() {

        val nombre = editNombreProducto.text.toString()
        val precioTexto = editPrecioProducto.text.toString()
        val stockTexto = editStockProducto.text.toString()

        if (nombre.isEmpty() ||
            precioTexto.isEmpty() ||
            stockTexto.isEmpty()
        ) {
            Toast.makeText(
                this,
                "Complete todos los campos",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val precio = precioTexto.toDouble()
        val stock = stockTexto.toInt()

        Thread {

            val dao = FacturacionApp.database.facturacionDao()

            dao.insertProducto(
                ProductoEntity(
                    nombre = nombre,
                    precio = precio,
                    stock = stock
                )
            )

            runOnUiThread {

                Toast.makeText(
                    this,
                    "Producto registrado correctamente",
                    Toast.LENGTH_SHORT
                ).show()

                editNombreProducto.text.clear()
                editPrecioProducto.text.clear()
                editStockProducto.text.clear()

                mostrarInventario()
            }

        }.start()
    }

    private fun mostrarInventario() {

        Thread {

            val dao = FacturacionApp.database.facturacionDao()

            val productos = dao.obtenerTodosLosProductos()

            val resultado = StringBuilder()

            if (productos.isEmpty()) {

                resultado.append("No hay productos registrados.")

            } else {

                for (producto in productos) {

                    resultado.append(
                        "ID: ${producto.idProducto}\n" +
                                "Producto: ${producto.nombre}\n" +
                                "Precio: $${producto.precio}\n" +
                                "Stock: ${producto.stock}\n" +
                                "--------------------------\n"
                    )
                }
            }

            runOnUiThread {

                textInventario.text = resultado.toString()

            }

        }.start()
    }
}
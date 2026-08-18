package com.example.sistemafacturacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.sistemafacturacion.database.ClienteEntity
import com.example.sistemafacturacion.database.FacturaEntity
import com.example.sistemafacturacion.database.ProductoEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var editRnc: EditText
    private lateinit var editNombreCliente: EditText
    private lateinit var editProductoId: EditText
    private lateinit var editCantidad: EditText
    private lateinit var btnProcesar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editRnc = findViewById(R.id.editRnc)
        editNombreCliente = findViewById(R.id.editNombreCliente)
        editProductoId = findViewById(R.id.editProductoId)
        editCantidad = findViewById(R.id.editCantidad)
        btnProcesar = findViewById(R.id.btnProcesar)

        val btnInventario = findViewById<Button>(R.id.btnInventario)

        insertarProductoDemo()

        btnProcesar.setOnClickListener {
            procesarFactura()
        }

        btnInventario.setOnClickListener {
            val intent = Intent(this, InventarioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun procesarFactura() {

        val rnc = editRnc.text.toString()
        val nombreCliente = editNombreCliente.text.toString()
        val prodIdStr = editProductoId.text.toString()
        val cantStr = editCantidad.text.toString()

        if (rnc.isEmpty() ||
            nombreCliente.isEmpty() ||
            prodIdStr.isEmpty() ||
            cantStr.isEmpty()
        ) {
            showToast("Complete todos los campos")
            return
        }

        val prodId = prodIdStr.toInt()
        val cantidad = cantStr.toInt()

        Thread {

            val dao = FacturacionApp.database.facturacionDao()

            val producto = dao.getProductoById(prodId)

            if (producto == null) {
                runOnUiThread {
                    showToast("Producto no encontrado")
                }
                return@Thread
            }

            if (producto.stock < cantidad) {
                runOnUiThread {
                    showToast(
                        "Stock insuficiente (${producto.stock} disponibles)"
                    )
                }
                return@Thread
            }

            val cliente = ClienteEntity(
                rnc,
                nombreCliente,
                "Dirección genérica"
            )

            dao.insertCliente(cliente)

            val total = producto.precio * cantidad

            producto.stock -= cantidad

            dao.updateProducto(producto)

            val fecha = SimpleDateFormat(
                "yyyy-MM-dd HH:mm",
                Locale.getDefault()
            ).format(Date())

            val factura = FacturaEntity(
                clienteRnc = rnc,
                productoId = prodId,
                cantidad = cantidad,
                total = total,
                fecha = fecha
            )

            dao.insertFactura(factura)

            runOnUiThread {

                val archivoPdf = PdfGenerator.generarRecibo(
                    this@MainActivity,
                    rnc,
                    nombreCliente,
                    producto.nombre,
                    cantidad,
                    producto.precio,
                    total,
                    fecha
                )

                val uri = FileProvider.getUriForFile(
                    this@MainActivity,
                    "${applicationContext.packageName}.fileprovider",
                    archivoPdf
                )

                val intent = Intent(Intent.ACTION_VIEW).apply {
                    setDataAndType(uri, "application/pdf")
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }

                startActivity(intent)

                showToast("¡Factura Creada! Total: $$total")

                limpiarCampos()
            }

        }.start()
    }

    private fun insertarProductoDemo() {

        Thread {

            val dao = FacturacionApp.database.facturacionDao()

            if (dao.getProductoById(1) == null) {

                dao.insertProducto(
                    ProductoEntity(
                        idProducto = 1,
                        nombre = "Laptop",
                        precio = 500.0,
                        stock = 10
                    )
                )
            }

        }.start()
    }

    private fun limpiarCampos() {

        editRnc.text.clear()
        editNombreCliente.text.clear()
        editProductoId.text.clear()
        editCantidad.text.clear()
    }

    private fun showToast(mensaje: String) {

        Toast.makeText(
            this,
            mensaje,
            Toast.LENGTH_SHORT
        ).show()
    }
}
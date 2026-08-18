package com.example.sistemafacturacion

import android.content.Context
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import java.io.File
import java.io.FileOutputStream

object PdfGenerator {

    fun generarRecibo(
        context: Context,
        rnc: String,
        nombreCliente: String,
        producto: String,
        cantidad: Int,
        precio: Double,
        total: Double,
        fecha: String
    ): File {

        val pdfDocument = PdfDocument()

        val pageInfo = PdfDocument.PageInfo.Builder(
            595,
            842,
            1
        ).create()

        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val paint = Paint()
        paint.textSize = 18f
        paint.isFakeBoldText = true

        canvas.drawText("SISTEMA DE FACTURACIÓN", 170f, 60f, paint)

        paint.textSize = 14f
        paint.isFakeBoldText = false

        canvas.drawText("RECIBO DE FACTURA", 220f, 90f, paint)

        canvas.drawText("Fecha: $fecha", 50f, 140f, paint)
        canvas.drawText("RNC / Cédula: $rnc", 50f, 170f, paint)
        canvas.drawText("Cliente: $nombreCliente", 50f, 200f, paint)

        canvas.drawText("Producto: $producto", 50f, 250f, paint)
        canvas.drawText("Cantidad: $cantidad", 50f, 280f, paint)
        canvas.drawText("Precio unitario: $$precio", 50f, 310f, paint)

        paint.isFakeBoldText = true
        paint.textSize = 18f

        canvas.drawText("TOTAL: $$total", 50f, 360f, paint)

        paint.textSize = 14f
        paint.isFakeBoldText = false

        canvas.drawText("Gracias por su compra.", 50f, 420f, paint)

        pdfDocument.finishPage(page)

        val archivo = File(
            context.getExternalFilesDir(null),
            "recibo_factura.pdf"
        )

        FileOutputStream(archivo).use {
            pdfDocument.writeTo(it)
        }

        pdfDocument.close()

        return archivo
    }
}
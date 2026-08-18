package com.example.tareakotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MiInterfazOperaciones {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ejecutarTareaInicial()
        procesarResultado(200)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val resultados = """
            1. ${ej1_variables()}
            2. ${ej2_aritmetica()}
            3. ${ej3_colecciones()}
            4. ${ej4_funciones()}
            5. ${ej5_condicional()}
            6. ${ej6_when()}
            7. ${ej7_bucles()}
            8. ${ej8_nullSafety()}
            9. ${ej9_clasesYHerencia()}
            10. ${ej10_interfaz()}
        """.trimIndent()

        txtResultado.text = resultados
    }

    // 1. Variables y Constantes
    fun ej1_variables(): String {
        val nombre = "Aristides"
        var edad = 24
        val activo = true
        edad = 25

        return "Nombre: $nombre, Edad: $edad, Activo: $activo"
    }

    // 2. Operaciones Aritméticas y Conversión
    fun ej2_aritmetica(): String {
        val n1 = 20
        val n2 = 8.4f

        val suma = n1 + n2.toInt()
        val resta = n1 - 5
        val mult = n1 * 2
        val div = n1 / 4
        val mod = n1 % 3

        return "Suma: $suma, Resta: $resta, Mult: $mult, Div: $div, Mod: $mod"
    }

    // 3. Colecciones
    fun ej3_colecciones(): String {
        val lista = listOf("Enero", "Febrero", "Marzo", "Abril")
        return "Lista: $lista"
    }

    // 4. Funciones
    fun ej4_funciones(): String {
        fun saludar(nombre: String): String {
            return "Hola $nombre"
        }

        return saludar("Aristides")
    }

    // 5. Condicionales
    fun ej5_condicional(): String {
        return if (25 >= 18) "Es mayor de edad" else "Es menor de edad"
    }

    // 6. When
    fun ej6_when(): String {
        return when ("Lunes") {
            "Lunes" -> "Inicio de semana"
            else -> "Otro día"
        }
    }

    // 7. Bucles
    fun ej7_bucles(): String {
        var forRes = ""
        for (i in 1..5) {
            forRes += "$i "
        }

        var doRes = ""
        var contador = 1
        do {
            doRes += "$contador "
            contador++
        } while (contador <= 2)

        return "For: $forRes Do-While: $doRes"
    }

    // 8. Null Safety
    fun ej8_nullSafety(): String {
        val nombre: String? = null
        return "Longitud: ${nombre?.length ?: 0}"
    }

    // 9. Data Class y Herencia
    fun ej9_clasesYHerencia(): String {
        val persona = Persona("Aristides", 25)
        val deportivo = CocheDeportivo("Ferrari")

        return "Persona: ${persona.nombre}, Vehículo: ${deportivo.model}"
    }

    // 10. Interfaces
    fun ej10_interfaz(): String {
        return "Interfaz implementada correctamente"
    }

    override fun ejecutarTareaInicial() {
        Log.d("TareaKotlin", "Inicializando procesos...")
    }

    override fun procesarResultado(codigo: Int) {
        Log.d("TareaKotlin", "Resultado procesado. Código: $codigo")
    }
}

// Data Class
data class Persona(val nombre: String, val edad: Int)

// Herencia
open class Vehiculo(val model: String)

class CocheDeportivo(model: String) : Vehiculo(model)

// Interfaz
interface MiInterfazOperaciones {
    fun ejecutarTareaInicial()
    fun procesarResultado(codigo: Int)
}
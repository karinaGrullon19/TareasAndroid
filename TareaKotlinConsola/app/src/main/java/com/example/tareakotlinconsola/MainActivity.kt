package com.example.tareakotlinconsola

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Aquí arranca tu tarea en la consola interna de Android Studio
        println("=== INICIO DE LA ASIGNACIÓN DE KOTLIN ===")

        ejercicio1_Variables()
        ejercicio2_Aritmetica()
        ejercicio3_Colecciones()
        ejercicio4_Funciones()
        ejercicio5_Condicionales()
        ejercicio6_StructureWhen()
        ejercicio7_Bucles()
        ejercicio8_NullSafety()
        ejercicio9_ClasesYHerencia()
        ejercicio10_Interfaces()
    }

    // 1. Declaración de Variables, Constantes y Concatenación
    private fun ejercicio1_Variables() {
        println("--- Ejercicio 1 ---")
        val nombre: String = "Karina"
        var edad: Int = 24
        val activo: Boolean = true
        edad = 25
        println("Me llamo $nombre y tengo $edad años. Activo: $activo")
    }

    // 2. Operaciones Aritméticas y Conversión de Tipos
    private fun ejercicio2_Aritmetica() {
        println("--- Ejercicio 2 ---")
        val numero1: Int = 20
        val numero2: Float = 8.4f
        val resultadoSuma = numero1 + numero2.toInt()
        val resta = numero1 - 5
        val multiplicacion = numero1 * 2
        val division = numero1 / 4
        val modulo = numero1 % 3

        println("Suma con Casteo: $resultadoSuma")
        println("Resta: $resta | Multiplicación: $multiplicacion")
        println("División: $division | Módulo: $modulo")

        val textoNumero = "22"
        val numeroConvertido = textoNumero.toInt() + 2
        println("Texto convertido a número + 2: $numeroConvertido")
    }

    // 3. Manejo de Arrays y Listas con Filtros
    private fun ejercicio3_Colecciones() {
        println("--- Ejercicio 3 ---")
        val mesesArray = arrayOf("Enero", "Febrero", "Marzo", "Abril")
        mesesArray[0] = "Mes modificado"

        val mesesLista = listOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio")
        val mesesLargos = mesesLista.filter { it.length > 5 }
        println("Meses filtrados (> 5 letras): $mesesLargos")

        val listaCompras: MutableList<String> = mutableListOf()
        listaCompras.add("potatoes")
        listaCompras.add("beers")
        listaCompras.add("bread")
        listaCompras.add(0, "salad")
        println("Lista mutable de compras: $listaCompras")
    }

    // 4. Funciones con Parámetros de Entrada y Salida
    private fun mostrarDatosUsuario(name: String, age: String) {
        println("Me llamo $name y tengo $age años")
    }
    private fun formatearNombre(name: String): String = "Me llamo $name"
    private fun obtenerSaludoCorto(name: String): String = "Hola de nuevo, $name"

    private fun ejercicio4_Funciones() {
        println("--- Ejercicio 4 ---")
        mostrarDatosUsuario("Karina", "24")
        println(formatearNombre("Aristides"))
        println(obtenerSaludoCorto("Henyer"))
    }

    // 5. Estructuras de Control Condicional
    private fun verificarNumero(number: Int) {
        if (number > 10 && number < 50) {
            println("$number está entre 11 y 49")
        } else if (number < 10 || number > 50) {
            println("$number es menor que 10 o mayor que 50")
        } else {
            println("$number es exactamente 10 o 50")
        }
    }
    private fun ejercicio5_Condicionales() {
        println("--- Ejercicio 5 ---")
        verificarNumero(25)
    }

    // 6. Control de Flujo Avanzado con la Estructura when
    private fun evaluarMesYTipo(month: Int, objetoCualquiera: Any) {
        when (month) {
            in 1..3 -> println("Primer trimestre del año")
            in 4..6 -> println("Segundo trimestre del año")
            in 7..12 -> println("Segundo semestre del año")
            else -> println("No es un mes válido")
        }
        val resultadoTipo: String = when (objetoCualquiera) {
            is Int -> "Es una variable de tipo Int"
            is String -> "Es una variable de tipo String"
            else -> "Es otro tipo de variable"
        }
        println(resultadoTipo)
    }
    private fun ejercicio6_StructureWhen() {
        println("--- Ejercicio 6 ---")
        evaluarMesYTipo(2, "Hola")
    }

    // 7. Estructuras Iterativas (Bucles for y do-while)
    private fun ejercicio7_Bucles() {
        println("--- Ejercicio 7 ---")
        val meses = listOf("Enero", "Febrero", "Marzo", "Abril")
        for ((posicion, valor) in meses.withIndex()) {
            println("La posición $posicion contiene el valor $valor")
        }
        var contador = 1
        do {
            println("Contador en do-while: $contador")
            contador++
        } while (contador <= 3)
    }

    // 8. Manejo Seguro de Nulos (Null Safety)
    private fun ejercicio8_NullSafety() {
        println("--- Ejercicio 8 ---")
        var apellido: String? = "Aris"
        apellido = null
        val longitudSegura: Int? = apellido?.length
        println("Longitud segura o nula: $longitudSegura")
        val longitudConDefault: Int = apellido?.length ?: -1
        println("Longitud controlled con Elvis: $longitudConDefault")
    }

    // 9. Clases de Objetos, Data Classes y Herencia
    data class CarroContenedor(val model: String, val power: Int)
    open class Vehiculo(val model: String) {
        open fun acelerar() { println("El vehículo base está acelerando...") }
    }
    class CocheDeportivo(model: String, val asientos: Int) : Vehiculo(model) {
        override fun acelerar() {
            super.acelerar()
            println("¡El coche deportivo $model con $asientos asientos vuela!")
        }
    }
    private fun ejercicio9_ClasesYHerencia() {
        println("--- Ejercicio 9 ---")
        val miCarroData = CarroContenedor("Toyota", 150)
        println("Datos del data class: $miCarroData")
        val miDeportivo = CocheDeportivo("Ferrari", 2)
        miDeportivo.acelerar()
    }

    // 10. Declaración e Implementación de Interfaces
    interface MiInterfazOperaciones {
        fun ejecutarTareaInicial()
        fun procesarResultado(codigo: Int)
    }
    class ClaseEjemploInterface : MiInterfazOperaciones {
        override fun ejecutarTareaInicial() { println("Tarea inicial de la interfaz ejecutada.") }
        override fun procesarResultado(codigo: Int) { println("Resultado procesado con código: $codigo") }
    }
    private fun ejercicio10_Interfaces() {
        println("--- Ejercicio 10 ---")
        val objetoPrueba = ClaseEjemploInterface()
        objetoPrueba.ejecutarTareaInicial()
        objetoPrueba.procesarResultado(200)
    }
}
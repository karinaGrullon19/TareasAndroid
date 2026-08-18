package com.example.tarea10catalogoanimales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
class FragmentReptiles : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val vista = inflater.inflate(
            R.layout.fragment_reptiles,
            container,
            false
        )

        recyclerView = vista.findViewById(R.id.recyclerAnimales)

        val animales = listOf(
            Animal("Serpiente", "Reptil", "🐍"),
            Animal("Tortuga", "Reptil", "🐢"),
            Animal("Cocodrilo", "Reptil", "🐊")
        )

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        recyclerView.adapter = AnimalAdapter(animales) { animal ->

            Toast.makeText(
                requireContext(),
                "Seleccionaste: ${animal.nombre}",
                Toast.LENGTH_SHORT
            ).show()

        }

        return vista
    }
}
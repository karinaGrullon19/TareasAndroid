package com.example.tarea10catalogoanimales

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(
    private val listaAnimales: List<Animal>,
    private val onClick: (Animal) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val emoji: TextView = view.findViewById(R.id.txtEmoji)
        val nombre: TextView = view.findViewById(R.id.txtNombre)
        val tipo: TextView = view.findViewById(R.id.txtTipo)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {

        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(vista)
    }


    override fun onBindViewHolder(
        holder: AnimalViewHolder,
        position: Int
    ) {

        val animal = listaAnimales[position]

        holder.emoji.text = animal.emoji
        holder.nombre.text = animal.nombre
        holder.tipo.text = animal.tipo
        holder.itemView.setOnClickListener {
            onClick(animal)
        }


    }


    override fun getItemCount(): Int {
        return listaAnimales.size
    }
}

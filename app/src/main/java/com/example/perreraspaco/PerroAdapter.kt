package com.example.perreraspaco

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.perreraspaco.databinding.PerroLayoutBinding
import com.example.perreraspaco.db.AppDataBase
import com.example.perreraspaco.model.Perro

class PerroAdapter(var perros:List<Perro>, val context: Context, val db:AppDataBase):
    RecyclerView.Adapter<PerroAdapter.ItemViewHolder> (){

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.perro_layout, null)
        )
    }

    override fun getItemCount(): Int {
        return perros.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val perro=perros[position]
        val binding = PerroLayoutBinding.bind(holder.itemView)

        binding.tvNombrePerro.text = perro.nombre
        binding.tvEdad.text = perro.edad.toString()
        binding.tvRaza.text = perro.raza
        binding.tvSexo.text = perro.sexo
        binding.tvNumChip.text = perro.chip

        binding.editButton.setOnClickListener {
            Toast.makeText(context, "Editando el perro ${perro.nombre}", Toast.LENGTH_LONG).show()
        }
        binding.deleteButton.setOnClickListener {
            Toast.makeText(context, "Eliminando el perro ${perro.nombre}", Toast.LENGTH_LONG).show()
            db.perroDao().delete(perro.chip)
            perros=db.perroDao().list()
            notifyDataSetChanged()
        }
    }


}
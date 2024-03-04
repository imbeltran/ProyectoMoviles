package com.example.perreraspaco

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.perreraspaco.databinding.PerroLayoutAdoptarBinding
import com.example.perreraspaco.db.AppDataBase
import com.example.perreraspaco.model.Perro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PerroAdoptarAdapter(var perros:List<Perro>, val context: Context, val db:AppDataBase):
    RecyclerView.Adapter<PerroAdoptarAdapter.ItemViewHolder> (){

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.perro_layout_adoptar, null)
        )
    }

    override fun getItemCount(): Int {
        return perros.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val perro = perros[position]
        val binding = PerroLayoutAdoptarBinding.bind(holder.itemView)

        binding.tvNombrePerro.text = perro.nombre
        binding.tvEdad.text = perro.edad.toString()
        binding.tvRaza.text = perro.raza
        binding.tvSexo.text = perro.sexo
        binding.tvNumChip.text = perro.chip

        binding.adoptarButton.setOnClickListener {
            Toast.makeText(context, "Adoptando el perro: ${perro.nombre}", Toast.LENGTH_LONG).show()
            db.perroDao().delete(perro.chip)
            perros = db.perroDao().list()
            notifyDataSetChanged()
        }
    }

}
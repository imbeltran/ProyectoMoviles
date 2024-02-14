package com.example.perreraspaco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.room.Room
import com.example.perreraspaco.databinding.ActivityRegistrarPerroBinding
import com.example.perreraspaco.db.AppDataBase
import com.example.perreraspaco.model.Perro

class RegistrarPerroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarPerroBinding
    private lateinit var db: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarPerroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar3)

        db = Room
            .databaseBuilder(
                this,
                AppDataBase::class.java,
                AppDataBase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.botonRegistrar.setOnClickListener{
            val perro = Perro(binding.eTChip.text.toString(), binding.eTNombre.text.toString(), binding.eTRaza.text.toString(), binding.eTEdad.text.toString().toInt(), binding.spinnerSexo.selectedItem.toString())
            Toast.makeText(this, "Perro " +perro.nombre+" añadido", Toast.LENGTH_LONG).show()
            db.perroDao().save(perro)
            val listadoPerrosActivityIntent = Intent(this, ListadoPerrosActivity::class.java)
            startActivity(listadoPerrosActivityIntent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.principalItem -> {
                val mainActivityIntent = Intent(this, MainActivity::class.java)
                startActivity(mainActivityIntent)
                return true

            }
            R.id.adoptaritem -> {
                val adoptarPerroActivityIntent = Intent(this, AdoptarPerroActivity::class.java)
                startActivity(adoptarPerroActivityIntent)
                return true

            }
            R.id.registrarItem -> {
                val registrarPerroActivityIntent = Intent(this, RegistrarPerroActivity::class.java)
                startActivity(registrarPerroActivityIntent)
                return true

            }
            R.id.listadoItem -> {
                val listadoPerrosActivityIntent = Intent(this, ListadoPerrosActivity::class.java)
                startActivity(listadoPerrosActivityIntent)
                return true

            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}
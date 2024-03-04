package com.example.perreraspaco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.perreraspaco.databinding.ActivityAdoptarPerroBinding
import com.example.perreraspaco.db.AppDataBase

class AdoptarPerroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdoptarPerroBinding
    private lateinit var db: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdoptarPerroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar2)

        db = Room
            .databaseBuilder(
                this,
                AppDataBase::class.java,
                AppDataBase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()


        binding.perroRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)
        binding.perroRecyclerView.adapter = PerroAdoptarAdapter(
            db.perroDao().list(), this, db
        )

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
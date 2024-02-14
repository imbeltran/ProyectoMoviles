package com.example.perreraspaco.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.perreraspaco.db.dao.PerroDao
import com.example.perreraspaco.model.Perro

@Database(entities= [Perro::class], version = 2)
abstract class AppDataBase: RoomDatabase() {
    companion object {
        val DATABASE_NAME="perros"
    }
    abstract fun perroDao():PerroDao
}
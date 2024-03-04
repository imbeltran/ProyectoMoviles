package com.example.perreraspaco.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.perreraspaco.model.Perro

@Dao
interface PerroDao {
    @Query ("SELECT * FROM perros")
    fun list(): List<Perro>

    @Query ("DELETE FROM perros WHERE chip=:chip")
    fun delete(chip: String)

    @Insert
    fun save(book: Perro)

    @Update ()
    fun updatePerro(perro: Perro)
}
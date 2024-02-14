package com.example.perreraspaco.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="perros")
data class Perro(
    @PrimaryKey val chip: String,
    @ColumnInfo ("nombre")val nombre: String,
    @ColumnInfo ("raza")val raza: String,
    @ColumnInfo ("edad")val edad: Int,
    @ColumnInfo ("sexo")val sexo: String,
)

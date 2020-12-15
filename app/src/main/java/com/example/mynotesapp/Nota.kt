package com.example.mynotesapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nota(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val titulo:String = "",
    val contenido:String = ""
)

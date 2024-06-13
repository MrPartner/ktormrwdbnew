package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class InstitutoModel(
    val instituto: String,
    val direccion: String,
    val audiencia: String,
    val taller: String,
    val descripcion: String,
    val costo: String,
    val fecha: String,
    val hora: String
)

package com.example

import com.example.entities.InstitutoEntity
import com.example.models.InstitutoModel
import com.example.network.DatabaseConnectionInstituto
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select

fun Application.runworkshopRouter() {

    val dbInstituto = DatabaseConnectionInstituto.database


    routing {
        //GET show values from database
        get("/rwinstitutos") {
            val rwinstitutos = dbInstituto.from(InstitutoEntity).select()
                .map {
                    val instituto = it[InstitutoEntity.instituto]
                    val direccion = it[InstitutoEntity.direccion]
                    val audiencia = it[InstitutoEntity.audiencia]
                    val taller = it[InstitutoEntity.taller]
                    val descripcion = it[InstitutoEntity.descripcion]
                    val costo = it[InstitutoEntity.costo]
                    val fecha = it[InstitutoEntity.fecha]
                    val hora = it[InstitutoEntity.hora]
                    InstitutoModel(
                        instituto ?: "",
                        direccion ?: "",
                        audiencia ?: "",
                        taller ?: "",
                        descripcion ?: "",
                        costo ?: "",
                        fecha ?: "",
                        hora ?: ""
                    )
                }

            call.respond(rwinstitutos)
        }
    }
}
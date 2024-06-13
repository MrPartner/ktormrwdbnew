package com.example

import com.example.entities.ConsultoraEntity
import com.example.entities.InstitutoEntity
import com.example.entities.UniversidadEntity
import com.example.models.ConsultoraModel
import com.example.models.InstitutoModel
import com.example.models.UniversidadModel
import com.example.network.DatabaseConnectionConsultora
import com.example.network.DatabaseConnectionInstituto
import com.example.network.DatabaseConnectionUniversidad
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select

fun Application.runworkshopRouter() {

    val dbInstituto = DatabaseConnectionInstituto.databaseInstituto
    val dbUniversidad = DatabaseConnectionUniversidad.databaseUniversidad
    val dbConsultora = DatabaseConnectionConsultora.databaseConsultora


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

        get("/rwuniversidades") {
            val rwuniversidades = dbUniversidad.from(UniversidadEntity).select()
                .map {
                    val universidad = it[UniversidadEntity.universidad]
                    val direccion = it[UniversidadEntity.direccion]
                    val audiencia = it[UniversidadEntity.audiencia]
                    val taller = it[UniversidadEntity.taller]
                    val descripcion = it[UniversidadEntity.descripcion]
                    val costo = it[UniversidadEntity.costo]
                    val fecha = it[UniversidadEntity.fecha]
                    val hora = it[UniversidadEntity.hora]
                    UniversidadModel(
                        universidad ?: "",
                        direccion ?: "",
                        audiencia ?: "",
                        taller ?: "",
                        descripcion ?: "",
                        costo ?: "",
                        fecha ?: "",
                        hora ?: ""
                    )
                }

            call.respond(rwuniversidades)
        }

        get("/rwconsultoras") {
            val rwconsultoras = dbConsultora.from(ConsultoraEntity).select()
                .map {
                    val consultora = it[ConsultoraEntity.consultora]
                    val direccion = it[ConsultoraEntity.direccion]
                    val audiencia = it[ConsultoraEntity.audiencia]
                    val taller = it[ConsultoraEntity.taller]
                    val descripcion = it[ConsultoraEntity.descripcion]
                    val costo = it[ConsultoraEntity.costo]
                    val fecha = it[ConsultoraEntity.fecha]
                    val hora = it[ConsultoraEntity.hora]
                    ConsultoraModel(
                        consultora ?: "",
                        direccion ?: "",
                        audiencia ?: "",
                        taller ?: "",
                        descripcion ?: "",
                        costo ?: "",
                        fecha ?: "",
                        hora ?: ""
                    )
                }

            call.respond(rwconsultoras)
        }


    }
}
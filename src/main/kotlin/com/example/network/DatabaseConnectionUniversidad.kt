package com.example.network

import org.ktorm.database.Database

object DatabaseConnectionUniversidad {
    val databaseUniversidades = Database.connect(
        url = "jdbc:mysql://localhost:3306/rwuniversidades",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "administrador"
    )
}
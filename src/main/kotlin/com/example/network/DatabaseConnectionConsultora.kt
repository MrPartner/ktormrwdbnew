package com.example.network

import org.ktorm.database.Database

object DatabaseConnectionConsultora {
    val databaseConsultora = Database.connect(
        url = "jdbc:mysql://localhost:3306/rwconsultoras",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "daniel3105"
    )
}
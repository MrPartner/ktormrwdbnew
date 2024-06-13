package com.example.network

import org.ktorm.database.Database

object DatabaseConnectionInstituto {
    val database = Database.connect(
        url = "jdbc:mysql://localhost:3306/rwinstitutos",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "daniel3105"
    )
}
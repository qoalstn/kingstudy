package org.example.study.model

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*

object Manager : IntIdTable("manager") {
    val name = varchar("name", 100)
    val email = varchar("email", 255)
}
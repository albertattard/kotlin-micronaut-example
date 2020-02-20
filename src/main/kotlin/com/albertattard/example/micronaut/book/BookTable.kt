package com.albertattard.example.micronaut.book

import org.jetbrains.exposed.dao.LongIdTable

object BookTable : LongIdTable("book") {
    val title = varchar("title", 128)
}

package com.albertattard.example.book

import org.jetbrains.exposed.dao.LongIdTable

object BookTable : LongIdTable("book") {
    val title = varchar("title", 128)
}

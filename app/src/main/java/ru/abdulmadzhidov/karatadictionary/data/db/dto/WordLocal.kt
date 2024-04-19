package ru.abdulmadzhidov.karatadictionary.data.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kar_rus")
data class WordLocal(
    @PrimaryKey val id: Int,
    val word: String,
    val translation: String
)
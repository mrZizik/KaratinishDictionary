package ru.abdulmadzhidov.karatadictionary.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal

@Dao
interface WordsDao {
    @Query("SELECT * FROM wordlocal")
    fun subscribeAllWords(): Flow<List<WordLocal>>
}
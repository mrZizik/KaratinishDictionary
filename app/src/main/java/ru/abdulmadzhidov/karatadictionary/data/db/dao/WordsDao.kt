package ru.abdulmadzhidov.karatadictionary.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal

@Dao
interface WordsDao {
    @Query("SELECT * FROM kar_rus")
    fun pagingSourceWords(): PagingSource<Int, WordLocal>
}
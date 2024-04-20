package ru.abdulmadzhidov.karatadictionary.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal

@Dao
interface WordsDao {
    @Query("SELECT * FROM kar_rus")
    fun pagingSourceWords(): PagingSource<Int, WordLocal>

    @Query("SELECT * FROM kar_rus " +
        "WHERE word LIKE '%' || :search || '%' " +
        "or translation LIKE '%' || :search || '%' " +
        "order by (case " +
        "when word like :search || '%' then 0 " +
        "when translation like :search || '%' then 1 " +
        "else 2 end)")
    fun pagingSourceWordsSearched(search: String): PagingSource<Int, WordLocal>
}
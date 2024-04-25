package ru.abdulmadzhidov.karatadictionary.data.db

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.abdulmadzhidov.karatadictionary.data.db.dao.WordsDao
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal

class SearchDataSourceFactory(private val dao: WordsDao) {

    private var query = ""
    private var pagingSource: PagingSource<Int, WordLocal>? = null

    fun setQuery(string: String) {
        query = string
        pagingSource?.invalidate()
    }

    fun load(): PagingSource<Int, WordLocal> {
        pagingSource = if (query.isEmpty()) {
            dao.pagingSourceWords()
        } else {
            dao.pagingSourceWordsSearched(query)
        }

        return pagingSource!!
    }
}
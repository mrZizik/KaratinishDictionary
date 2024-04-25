package ru.abdulmadzhidov.karatadictionary.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.abdulmadzhidov.karatadictionary.data.db.SearchDataSourceFactory
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal
import ru.abdulmadzhidov.karatadictionary.domain.model.Word

interface DictionaryRepository {
    fun subscribeWords(searchQuery: String = ""): Flow<PagingData<Word>>
    fun search(searchQuery: String)
}

class DictionaryRepositoryImpl(private val pager: Pager<Int, WordLocal>, private val dataSourceFactory: SearchDataSourceFactory): DictionaryRepository {
    override fun subscribeWords(searchQuery: String): Flow<PagingData<Word>> =
        pager.flow
            .flowOn(Dispatchers.IO)
            .map { it.map { Word(it.id, it.word, it.translation) } }

    override fun search(searchQuery: String) = dataSourceFactory.setQuery(searchQuery)
}
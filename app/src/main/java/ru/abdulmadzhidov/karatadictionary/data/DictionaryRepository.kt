package ru.abdulmadzhidov.karatadictionary.data

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.abdulmadzhidov.karatadictionary.data.db.dto.WordLocal
import ru.abdulmadzhidov.karatadictionary.domain.model.Word

interface DictionaryRepository {
    fun subscribeWords(): Flow<PagingData<Word>>
}

class DictionaryRepositoryImpl(private val pager: Pager<Int, WordLocal>): DictionaryRepository {
    override fun subscribeWords(): Flow<PagingData<Word>> = pager.flow.map { it.map { Word(it.id, it.word, it.translation) } }
}
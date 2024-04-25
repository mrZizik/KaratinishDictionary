package ru.abdulmadzhidov.karatadictionary.domain

import android.util.Log
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepository
import ru.abdulmadzhidov.karatadictionary.domain.model.Word
import javax.inject.Inject

interface DictionaryInteractor {
    fun subscribeWords(searchQuery: String = ""): Flow<PagingData<Word>>

    fun search(searchQuery: String)
}

class DictionaryInteractorImpl @Inject constructor(private val dictionaryRepository: DictionaryRepository): DictionaryInteractor {
    override fun subscribeWords(searchQuery: String): Flow<PagingData<Word>> = dictionaryRepository.subscribeWords(searchQuery)

    override fun search(searchQuery: String) = dictionaryRepository.search(searchQuery)
}
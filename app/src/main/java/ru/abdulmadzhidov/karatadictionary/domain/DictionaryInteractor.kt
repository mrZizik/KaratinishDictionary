package ru.abdulmadzhidov.karatadictionary.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepository
import ru.abdulmadzhidov.karatadictionary.domain.model.Word
import javax.inject.Inject

interface DictionaryInteractor {
    fun subscribeWords(): Flow<PagingData<Word>>
}

class DictionaryInteractorImpl @Inject constructor(private val dictionaryRepository: DictionaryRepository): DictionaryInteractor {
    override fun subscribeWords(): Flow<PagingData<Word>> = dictionaryRepository.subscribeWords()
}
package ru.abdulmadzhidov.karatadictionary.domain

import kotlinx.coroutines.flow.Flow
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepository
import ru.abdulmadzhidov.karatadictionary.domain.model.Word

interface DictionaryInteractor {
    fun subscribeWords(): Flow<List<Word>>
}

class DictionaryInteractorImpl(private val dictionaryRepository: DictionaryRepository): DictionaryInteractor {
    override fun subscribeWords(): Flow<List<Word>> = dictionaryRepository.subscribeWords()
}
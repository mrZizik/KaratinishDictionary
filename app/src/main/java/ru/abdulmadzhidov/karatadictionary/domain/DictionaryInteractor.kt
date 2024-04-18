package ru.abdulmadzhidov.karatadictionary.domain

import kotlinx.coroutines.flow.Flow
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepository
import ru.abdulmadzhidov.karatadictionary.data.DictionaryRepositoryImpl
import ru.abdulmadzhidov.karatadictionary.domain.model.Word
import javax.inject.Inject

interface DictionaryInteractor {
    fun subscribeWords(): Flow<List<Word>>
}

class DictionaryInteractorImpl @Inject constructor(private val dictionaryRepository: DictionaryRepositoryImpl): DictionaryInteractor {
    override fun subscribeWords(): Flow<List<Word>> = dictionaryRepository.subscribeWords()
}
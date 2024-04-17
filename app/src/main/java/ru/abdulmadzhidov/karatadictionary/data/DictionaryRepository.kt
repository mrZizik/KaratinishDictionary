package ru.abdulmadzhidov.karatadictionary.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.abdulmadzhidov.karatadictionary.domain.model.Word

interface DictionaryRepository {
    fun subscribeWords(): Flow<List<Word>>
}

class DictionaryRepositoryImpl: DictionaryRepository {
    override fun subscribeWords(): Flow<List<Word>> = flowOf(listOf(Word("Г1ече", "Яблоко")))
}
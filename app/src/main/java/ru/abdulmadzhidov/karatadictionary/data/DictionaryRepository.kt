package ru.abdulmadzhidov.karatadictionary.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import ru.abdulmadzhidov.karatadictionary.data.db.DictionaryDatabase
import ru.abdulmadzhidov.karatadictionary.domain.model.Word
import javax.inject.Inject

interface DictionaryRepository {
    fun subscribeWords(): Flow<List<Word>>
}

class DictionaryRepositoryImpl(private val db: DictionaryDatabase): DictionaryRepository {
    override fun subscribeWords(): Flow<List<Word>> = db.wordsDao().subscribeAllWords().map { it.map {
        Log.e("TAGAA", it.toString())
        Word(it.word, it.translation)
    } }
}
package ru.abdulmadzhidov.karatadictionary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractor
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(dictionaryInteractor: DictionaryInteractor): ViewModel() {

    val words = dictionaryInteractor.subscribeWords()
        .map {
            it.joinToString { it.title }
        }
}
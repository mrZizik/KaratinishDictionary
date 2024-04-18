package ru.abdulmadzhidov.karatadictionary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractorImpl
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(dictionaryInteractor: DictionaryInteractor): ViewModel() {

    val words = MutableStateFlow("")

    init {
        viewModelScope.launch {
            dictionaryInteractor.subscribeWords().collectLatest {
                words.emit(it.joinToString { it.title })
            }
        }
    }
}
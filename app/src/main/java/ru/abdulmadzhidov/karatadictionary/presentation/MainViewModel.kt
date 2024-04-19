package ru.abdulmadzhidov.karatadictionary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractor
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(dictionaryInteractor: DictionaryInteractor): ViewModel() {

    val words = dictionaryInteractor.subscribeWords().cachedIn(viewModelScope)
}
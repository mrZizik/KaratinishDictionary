package ru.abdulmadzhidov.karatadictionary.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import ru.abdulmadzhidov.karatadictionary.domain.DictionaryInteractor
import ru.abdulmadzhidov.karatadictionary.domain.model.Word
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dictionaryInteractor: DictionaryInteractor): ViewModel() {

    @OptIn(FlowPreview::class)
    var words = dictionaryInteractor.subscribeWords().debounce(100L)

    fun onSearchChange(query: String) {
        dictionaryInteractor.search(query)
    }
}
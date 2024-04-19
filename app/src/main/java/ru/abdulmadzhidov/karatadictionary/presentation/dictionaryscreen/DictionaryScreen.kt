package ru.abdulmadzhidov.karatadictionary.presentation.dictionaryscreen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import ru.abdulmadzhidov.karatadictionary.domain.model.Word

@Composable
fun DictionaryScreen(words: LazyPagingItems<Word>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(
            count = words.itemCount,
            key = words.itemKey { it.id },
            itemContent = {
                words[it]?.let {
                    Text(text = "${it.title} - ${it.translation}")
                }
            })
    }
}
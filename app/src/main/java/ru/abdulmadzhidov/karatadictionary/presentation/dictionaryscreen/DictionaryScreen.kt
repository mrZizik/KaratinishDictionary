package ru.abdulmadzhidov.karatadictionary.presentation.dictionaryscreen

import androidx.annotation.Dimension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import ru.abdulmadzhidov.karatadictionary.domain.model.Word

@Composable
fun DictionaryScreen(words: LazyPagingItems<Word>) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(
            count = words.itemCount,
            key = words.itemKey { it.id },
            itemContent = {
                words[it]?.let {
                    WordItem(it)
                    Spacer(modifier = Modifier.height(6.dp))
                }
            })
    }

    val isRefreshing = words.loadState.refresh is LoadState.NotLoading
    LaunchedEffect(isRefreshing) {
        if (!isRefreshing) {
            scrollState.scrollToItem(0)
        }
    }
}

@Composable
private fun WordItem(word: Word) {
    Card(
        modifier = Modifier,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors().copy(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .fillMaxWidth()
        ) {
            Text(style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onSurface, text = word.title)
            Text(style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold), color = MaterialTheme.colorScheme.onSurfaceVariant, text = word.translation)
        }
    }
}
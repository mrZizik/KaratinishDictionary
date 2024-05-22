package ru.abdulmadzhidov.karatadictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.AndroidEntryPoint
import ru.abdulmadzhidov.karatadictionary.R
import ru.abdulmadzhidov.karatadictionary.presentation.theme.DagestanDictionaryTheme
import ru.abdulmadzhidov.karatadictionary.presentation.util.SearchBar
import ru.abdulmadzhidov.karatadictionary.presentation.util.shareApp
import ru.abdulmadzhidov.karatadictionary.presentation.util.shareWord

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DagestanDictionaryTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Dictionary) {
                    composable(Dictionary) {
                        Scaffold(
                            topBar = {
                                Row(
                                    modifier = Modifier.background(MaterialTheme.colorScheme.primary),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .clickable { navController.navigate(About) }
                                            .padding(start = 8.dp)
                                            .size(36.dp),
                                        painter = painterResource(id = R.mipmap.ic_launcher),
                                        contentDescription = ""
                                    )
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(60.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        SearchBar(
                                            hint = stringResource(id = R.string.search_query),
                                            modifier = Modifier.padding(horizontal = 8.dp),
                                            onTextChange = vm::onSearchChange
                                        )
                                    }
                                }
                            }) {
                                Box(modifier = Modifier.padding(paddingValues = it)) {
                                    DictionaryScreen(words = vm.words.collectAsLazyPagingItems()) {
                                        shareWord(it.title, it.translation)
                                    }
                                }
                        }
                    }

                    composable(About) {
                        AboutScreen {
                            shareApp()
                        }
                    }

                }
            }
        }
    }
}
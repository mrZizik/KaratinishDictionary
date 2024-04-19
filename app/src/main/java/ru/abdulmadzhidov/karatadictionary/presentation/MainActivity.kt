package ru.abdulmadzhidov.karatadictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.AndroidEntryPoint
import ru.abdulmadzhidov.karatadictionary.presentation.dictionaryscreen.DictionaryScreen
import ru.abdulmadzhidov.karatadictionary.presentation.theme.DagestanDictionaryTheme

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
                        DictionaryScreen(words = vm.words.collectAsLazyPagingItems())
                    }

                    composable(Word) {
                        Text(text = "Hello Word")
                    }
                }
            }
        }
    }
}
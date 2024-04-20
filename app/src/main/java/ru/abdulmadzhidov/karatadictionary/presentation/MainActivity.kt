package ru.abdulmadzhidov.karatadictionary.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DagestanDictionaryTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Dictionary) {
                    composable(Dictionary) {

                        Scaffold(
                            topBar = {
                                SearchBar(
                                    query = "searchText",//text showed on SearchBar
                                    onQueryChange = { }, //update the value of searchText
                                    onSearch = {}, //the callback to be invoked when the input service triggers the ImeAction.Search action
                                    active = false, //whether the user is searching or not
                                    onActiveChange = { }, //the callback to be invoked when this search bar's active state is changed
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                ) {

                                }
                            }) {
                            DictionaryScreen(words = vm.words.collectAsLazyPagingItems())
                        }
                    }


                    composable(Word) {
                        Text(text = "Hello Word")
                    }
                }
            }
        }
    }
}
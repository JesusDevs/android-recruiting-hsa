package com.accenture.concrete.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.concrete.data.model.Item
import com.accenture.concrete.ui.GitHubRepoViewModel
import com.accenture.concrete.ui.screen.ItemRepo
import com.accenture.concrete.ui.theme.AccentureGoTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: GitHubRepoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccentureGoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val gitHubPagingItems: LazyPagingItems<Item> =  viewModel.gitHubRepositoryState.collectAsLazyPagingItems()
                    LazyColumn {
                        items(gitHubPagingItems.itemSnapshotList) { repo ->
                            repo?.let {
                                it.name?.let { it1 -> Text(text = it1) }
                            }
                        }
                    }


                  /*  LazyColumn(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        item { Spacer(modifier = Modifier.padding(4.dp)) }
                        items(gitHubPagingItems.itemCount) { item ->
                            ItemRepo(itemEntity = gitHubPagingItems[item]!!)
                        }

                    }*/
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello cool $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AccentureGoTheme {
        Greeting("Android")
    }
}

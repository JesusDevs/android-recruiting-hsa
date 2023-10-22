package com.accenture.concrete.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.accenture.concrete.data.model.Item
import com.accenture.concrete.ui.screen.items.GitHubRepositoryItem

@Composable
fun ItemListGithubRepo(gitHubPagingItems: LazyPagingItems<Item>) {
    val context = LocalContext.current
    LaunchedEffect(key1 = gitHubPagingItems.loadState) {
        if (gitHubPagingItems.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (gitHubPagingItems.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        if (gitHubPagingItems.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(gitHubPagingItems.itemSnapshotList) { itemRepo ->
                    if (itemRepo != null) {
                        GitHubRepositoryItem(
                            repo = itemRepo,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }
                }
                item {
                    if (gitHubPagingItems.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
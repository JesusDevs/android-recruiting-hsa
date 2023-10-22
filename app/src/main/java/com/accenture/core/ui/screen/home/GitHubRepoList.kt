package com.accenture.core.ui.screen.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.screen.home.items.ErrorMessage
import com.accenture.core.ui.screen.home.items.GitHubRepositoryItem
import com.accenture.core.ui.screen.home.items.ItemRepo
import com.accenture.core.ui.screen.home.items.LoadingNextPageItem
import com.accenture.core.ui.screen.home.items.PageLoader

@Composable
fun GitHubRepoList(
    paddingValues: PaddingValues,
    repoPagingItems: LazyPagingItems<Item>
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        item { Spacer(modifier = Modifier.padding(4.dp)) }
        items(repoPagingItems.itemCount) { index ->
            GitHubRepositoryItem( repo = repoPagingItems[index]!!)
        }
        repoPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { PageLoader(modifier = Modifier.fillParentMaxSize()) }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = repoPagingItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorMessage(
                            modifier = Modifier.fillParentMaxSize(),
                            message = error.error.localizedMessage!!,
                            onClickRetry = { retry() })
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item { LoadingNextPageItem(modifier = Modifier) }
                }

                loadState.append is LoadState.Error -> {
                    val error = repoPagingItems.loadState.append as LoadState.Error
                    item {
                        ErrorMessage(
                            modifier = Modifier,
                            message = error.error.localizedMessage!!,
                            onClickRetry = { retry() })
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.padding(4.dp)) }
    }
}
package com.accenture.core.ui.screen.details.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.ui.screen.home.items.ErrorMessage
import com.accenture.core.ui.screen.home.items.LoadingNextPageItem
import com.accenture.core.ui.screen.home.items.PageLoader



@Composable
fun GitHubPullList(
    paddingValues: PaddingValues,
    pullsPagingItems: LazyPagingItems<PullRequest>,
    onClickRepo: (PullRequest) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        item { Spacer(modifier = Modifier.padding(4.dp)) }
        items(pullsPagingItems.itemCount) { index ->
            GitHubPullItem(
                pull = pullsPagingItems[index]!!,
                onClick = { onClickRepo(pullsPagingItems[index]!!) })
        }
        pullsPagingItems.run {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { PageLoader(modifier = Modifier.fillParentMaxSize()) }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = pullsPagingItems.loadState.refresh as LoadState.Error
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
                    val error = pullsPagingItems.loadState.append as LoadState.Error
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
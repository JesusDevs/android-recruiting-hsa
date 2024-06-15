package com.accenture.core.ui.screen.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.mocks.mockValues
import com.accenture.core.ui.screen.home.component.TopBar
import com.accenture.core.ui.screen.home.items.GitHubRepoList
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeScreen(
    onClickRepo: (Item) -> Unit
) {
    val viewModelHilt = hiltViewModel<HomeGitHubRepoViewModel>()
    val repoPagingItems: LazyPagingItems<Item> =
        viewModelHilt.gitHubRepoState.collectAsLazyPagingItems()

    HomeScreenContent(repoPagingItems, onClickRepo)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun HomeScreenContent(
    repoPagingItems: LazyPagingItems<Item>,
    onClickRepo: (Item) -> Unit
) {
    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        GitHubRepoList(
            paddingValues = paddingValues,
            repoPagingItems = repoPagingItems,
            onClickRepo = onClickRepo
        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    val items = remember { mockValues() }
    val pagingData = PagingData.from(items)
    val lazyPagingItems = MutableStateFlow(pagingData).collectAsLazyPagingItems()

    HomeScreenContent(
        repoPagingItems = lazyPagingItems,
        onClickRepo = {}
    )
}


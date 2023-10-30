package com.accenture.core.ui.screen.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.screen.home.component.TopBar
import com.accenture.core.ui.screen.home.items.GitHubRepoList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickRepo: (Item) -> Unit
) {
    val viewModelHilt = hiltViewModel<HomeGitHubRepoViewModel>()
    val repoPagingItems: LazyPagingItems<Item> = viewModelHilt.gitHubRepoState.collectAsLazyPagingItems()

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

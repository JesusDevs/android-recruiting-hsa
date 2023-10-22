package com.accenture.core.ui.screen.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.GitHubRepoViewModel
import com.accenture.core.ui.screen.home.componentes.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: GitHubRepoViewModel = hiltViewModel()
) {
    val repoPagingItems: LazyPagingItems<Item> = viewModel.gitHubRepoState.collectAsLazyPagingItems()
    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        GitHubRepoList(
            paddingValues = paddingValues,
            repoPagingItems = repoPagingItems
        )
    }
}


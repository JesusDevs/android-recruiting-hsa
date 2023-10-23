package com.accenture.core.ui.screen.main

import android.service.autofill.OnClickAction
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.screen.main.componentes.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    repoPagingItems: LazyPagingItems<Item>,
    onClickRepoAction: (Item) -> Unit
) {
    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        GitHubRepoList(
            paddingValues = paddingValues,
            repoPagingItems = repoPagingItems,
            onClickAction = onClickRepoAction
        )
    }
}

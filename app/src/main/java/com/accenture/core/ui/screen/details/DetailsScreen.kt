package com.accenture.core.ui.screen.details

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.ui.screen.details.component.GitHubPullList
import com.accenture.core.ui.screen.details.component.TopBarDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    onUpClick: () -> Boolean,
) {
    val viewModel: DetailsViewModel = hiltViewModel()
    val pullPagingItems: LazyPagingItems<PullRequest>
    = viewModel.gitHubPullState.collectAsLazyPagingItems()

    LaunchedEffect(key1 = Unit){
        viewModel.getGitHubPull()
    }
    Scaffold(
        topBar = { TopBarDetail(
            title = "Pulls"?: "",
            onUpClick = onUpClick
        )
        }
    ) { paddingValues ->
        GitHubPullList(
            paddingValues = paddingValues,
            pullsPagingItems = pullPagingItems,
            onClickRepo = {}
        )
    }
}



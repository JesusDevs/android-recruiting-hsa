package com.accenture.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.screen.main.GitHubRepoMainViewModel
import com.accenture.core.ui.screen.main.HomeScreen

@Composable
fun Navigation(mainViewModel: GitHubRepoMainViewModel) {
    val navController = rememberNavController()
    val repoPagingItems: LazyPagingItems<Item> = mainViewModel.gitHubRepoState.collectAsLazyPagingItems()

    NavHost(
        navController = navController,
        startDestination = AppScreenNavigation.HomeScreen.route,
    ) {

        composable(route = AppScreenNavigation.HomeScreen.route) {
            HomeScreen(
                repoPagingItems = repoPagingItems
            )
        }
    }
}
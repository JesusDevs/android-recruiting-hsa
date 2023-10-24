package com.accenture.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.screen.details.DetailsScreen
import com.accenture.core.ui.screen.home.HomeScreen
import com.accenture.core.ui.screen.home.HomeGitHubRepoViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModelHilt = hiltViewModel<HomeGitHubRepoViewModel>()
    val repoPagingItems: LazyPagingItems<Item> = viewModelHilt.gitHubRepoState.collectAsLazyPagingItems()

    NavHost(
        navController = navController,
        startDestination = AppScreenNavigation.HomeScreen.route,
    ) {

        composable(route = AppScreenNavigation.HomeScreen.route) {
            HomeScreen(
                repoPagingItems = repoPagingItems,
                onClickRepo = { repo ->
                    navController.navigate(AppScreenNavigation.DetailsScreen.route + "/${repo.name}")
                }
            )
        }
        composable(
            route = AppScreenNavigation.DetailsScreen.route + "/{repoName}",
            arguments = listOf(navArgument("repoName") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(
                repoName  = backStackEntry.arguments?.getString("repoName"),
                onUpClick = { navController.popBackStack() }
            )
        }

    }
}
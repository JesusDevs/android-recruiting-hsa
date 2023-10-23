package com.accenture.core.ui.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
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
            ){
                ("Navigation: ${it.id}")
                navController.navigate(AppScreenNavigation.DetailsScreen.route)
            }
        }
    }
}

@Composable
fun Toast(message: String) {
    val context = LocalContext.current
    Toast.makeText(
                context,
        "Error: $message",
                Toast.LENGTH_LONG
            ).show()

}
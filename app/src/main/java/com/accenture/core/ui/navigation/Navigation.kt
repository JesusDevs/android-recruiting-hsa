package com.accenture.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.accenture.core.data.model.response.Item
import com.accenture.core.ui.screen.details.DetailsScreen
import com.accenture.core.ui.screen.home.HomeScreen
import com.accenture.core.ui.screen.home.HomeGitHubRepoViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Feature.HOME.route,
    ) {
        homeNav(navController)
    }
}

private fun NavGraphBuilder.homeNav(navController: NavController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.HOME).route,
        route = Feature.HOME.route
    ) {
        val homeCommand = NavCommand.ContentType(Feature.HOME).route
        val homeDetailCommand = NavCommand.ContentTypeDetail(Feature.HOME)

        composable(homeCommand) {
            HomeScreen(
                onClickRepo = { repo ->
                   val route = NavCommand.ContentTypeDetail(Feature.HOME).createRoute(repoName = repo.name!!, ownerLogin = repo.owner!!.login!!)
                    navController.navigate(route)
                }
            )
        }

        composable(homeDetailCommand.route) { backStackEntry ->
            /*val repoName = backStackEntry.arguments?.getString("repoName")
            val ownerLogin = backStackEntry.arguments?.getString("ownerLogin")*/

            DetailsScreen(
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

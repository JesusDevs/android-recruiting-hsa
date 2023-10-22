package com.accenture.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.accenture.core.ui.GitHubRepoViewModel
import com.accenture.core.ui.screen.home.HomeScreen

@Composable
fun Navigation(mainViewModel:GitHubRepoViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreenNavigation.HomeScreen.route,
    ) {

        composable(route = AppScreenNavigation.HomeScreen.route) {
            HomeScreen(
                viewModel = mainViewModel
            )
        }
    }
}
package com.accenture.core.ui.navigation
sealed class AppScreenNavigation(val route: String) {

    object HomeScreen : AppScreenNavigation(ConstantAppScreenName.HOME_SCREEN)

    object DetailsScreen :AppScreenNavigation(ConstantAppScreenName.DETAILS_SCREEN)
}

object ConstantAppScreenName {
    const val HOME_SCREEN = "home_screen"
    const val DETAILS_SCREEN = "details_screen"
}
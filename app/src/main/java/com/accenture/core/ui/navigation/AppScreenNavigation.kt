package com.accenture.core.ui.navigation



sealed class AppScreenNavigationV2(val route: String) {

    object HomeScreen : AppScreenNavigationV2("home_screen")

    object DetailsScreen : AppScreenNavigationV2("details_screen/{repoName}/{ownerLogin}") {
        fun route(repoName: String, ownerLogin: String) = withArgs(repoName, ownerLogin)
    }
}
fun withArgs(route: String,vararg args: String): String {
    return buildString {
        append(route)
        args.forEach {
            append("/$it")
        }
    }
}

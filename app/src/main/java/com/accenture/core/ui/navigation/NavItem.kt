package com.accenture.core.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavCommand(
    internal val feature: Feature,
    internal val subRoute: String = "home",
    private val navArgs: List<NavArg> = emptyList()
) {
    class ContentType(feature: Feature) : NavCommand(feature)

    class ContentTypeDetail(feature: Feature) :
        NavCommand(feature, "detail", listOf(NavArg.RepoName,NavArg.OwnerLogin)) {
        fun createRoute(ownerLogin: String,repoName:String) = "${feature.route}/$subRoute/$ownerLogin/$repoName"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(feature.route)
            .plus(subRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArg(val key: String, val navType: NavType<*>) {
    OwnerLogin(key = "ownerLogin", navType= NavType.StringType),
    RepoName("repoName", NavType.StringType)
}
enum class Feature(val route: String) {
    HOME("Home"),

    //agregar mas pantallas
    EVENTS("events"),
    COMICS("comics"),
    SETTINGS("settings")
}
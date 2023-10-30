package com.accenture.core.app.constant

import retrofit2.http.Path
import retrofit2.http.Query


object ServiceConstants {
    const val API_REPOSITORY = "search/repositories"
    const val API_ENDPOINT = "https://api.github.com/"
    const val API_PULL = "repos/{owner}/{repository}/pulls"

    const val QUERY_PARAMS = "q"
    const val SORT = "sort"
    const val STARS = "stars"
    const val PAGE = "page"
    const val PER_PAGE = "per_page"
    const val LANGUAJE = "language:Java"


    const val OWNER = "owner"
    const val REPOSITORY = "repository"

    const val PAGE_SIZE = 20
}

package com.accenture.core.data.repository.datasource

import com.accenture.core.data.remote.ApiService
import com.accenture.core.data.repository.datasource.pulls.GitHubPullsPagingSource
import com.accenture.core.data.repository.datasource.repo.GitHubRepositoryPagingSource
import com.accenture.core.domain.model.Pulls
import javax.inject.Inject

class GitHubPagingSourceFactory @Inject constructor(
    private val apiService: ApiService
) {
    fun createPullsPagingSource(pulls: Pulls): GitHubPullsPagingSource {
        return GitHubPullsPagingSource(apiService, pulls)
    }
    fun createRepoPagingSource(): GitHubRepositoryPagingSource {
        return GitHubRepositoryPagingSource(apiService)
    }

}

package com.accenture.core.domain.repository

import androidx.paging.PagingData
import com.accenture.core.data.model.response.Item
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.domain.model.Pulls
import kotlinx.coroutines.flow.Flow

interface GitHubRepositoryInterface {
    fun getGitHubRepository(): Flow<PagingData<Item>>
    fun getGitHubPulls(pulls: Pulls): Flow<PagingData<PullRequest>>
}

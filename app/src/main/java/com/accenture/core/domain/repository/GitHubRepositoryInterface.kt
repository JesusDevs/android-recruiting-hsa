package com.accenture.core.domain.repository

import androidx.paging.PagingData
import com.accenture.core.data.model.response.Item
import kotlinx.coroutines.flow.Flow

interface GitHubRepositoryInterface {
    fun getGitHubRepository(): Flow<PagingData<Item>>
}

package com.accenture.concrete.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.accenture.concrete.constant.ServiceConstants.PAGE_SIZE
import com.accenture.concrete.data.datasource.GitHubRepositoryPagingSource
import com.accenture.concrete.data.model.Item
import com.accenture.concrete.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitHubRepository @Inject constructor(private val apiService: ApiService) {
    fun getGitHubRepository(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = { GitHubRepositoryPagingSource(apiService) }
        ).flow
    }
}


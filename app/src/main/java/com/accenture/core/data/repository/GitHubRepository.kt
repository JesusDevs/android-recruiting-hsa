package com.accenture.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.accenture.core.app.constant.ServiceConstants.PAGE_SIZE
import com.accenture.core.data.repository.datasource.GitHubRepositoryPagingSource
import com.accenture.core.data.model.response.Item
import com.accenture.core.data.remote.ApiService
import com.accenture.core.domain.repository.GitHubRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitHubRepository @Inject constructor(
    private val apiService: ApiService
) : GitHubRepositoryInterface {
   override fun getGitHubRepository(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = {
                GitHubRepositoryPagingSource(apiService)
            }
        ).flow
    }
}



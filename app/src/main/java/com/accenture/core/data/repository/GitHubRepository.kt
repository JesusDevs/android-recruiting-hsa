package com.accenture.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.accenture.core.app.constant.ServiceConstants.PAGE_SIZE
import com.accenture.core.data.model.response.Item
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.data.repository.datasource.GitHubPagingSourceFactory
import com.accenture.core.domain.model.Pulls
import com.accenture.core.domain.repository.GitHubRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitHubRepository @Inject constructor(
    private val gitHubPagingSourceFactory: GitHubPagingSourceFactory
) : GitHubRepositoryInterface {
   override fun getGitHubRepository(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = {
                gitHubPagingSourceFactory.createRepoPagingSource()
            }
        ).flow
   }

    override fun getGitHubPulls(pulls: Pulls): Flow<PagingData<PullRequest>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = {
                gitHubPagingSourceFactory.createPullsPagingSource(pulls)
            }
        ).flow
    }

}



package com.accenture.core.data.repository.datasource.pulls

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.accenture.core.app.constant.ServiceConstants.PAGE_SIZE
import com.accenture.core.app.generic.error.Result
import com.accenture.core.app.generic.error.safeApiCall
import com.accenture.core.data.remote.ApiService
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.domain.model.Pulls
import javax.inject.Inject

class GitHubPullsPagingSource @Inject constructor(
    private val apiService: ApiService,
    private val pulls : Pulls
) : PagingSource<Int, PullRequest>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PullRequest> {

        val currentPage = params.key ?: 1
        val response = safeApiCall {
            apiService.getPullRequests(
                page = currentPage,
                perPage = PAGE_SIZE)
        }

        return when (response) {
            is Result.Success -> {
                val data = response.data
                LoadResult.Page(
                    data = data,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (data.isEmpty()) null else currentPage + 1
                )
            }
            is Result.Failure -> {
                LoadResult.Error(response.exception)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PullRequest>): Int? {
        return state.anchorPosition
    }
}




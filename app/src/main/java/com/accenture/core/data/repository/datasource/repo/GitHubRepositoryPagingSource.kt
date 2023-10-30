package com.accenture.core.data.repository.datasource.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.accenture.core.app.constant.ServiceConstants.LANGUAJE
import com.accenture.core.app.constant.ServiceConstants.PAGE_SIZE
import com.accenture.core.app.constant.ServiceConstants.STARS
import com.accenture.core.app.generic.error.Result
import com.accenture.core.app.generic.error.safeApiCall
import com.accenture.core.data.model.response.Item
import com.accenture.core.data.remote.ApiService
import javax.inject.Inject

class GitHubRepositoryPagingSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, Item>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {

        val currentPage = params.key ?: 1
        val response = safeApiCall {
            apiService.getRepository(
                query = LANGUAJE,
                sort = STARS,
                page = currentPage,
                perPage = PAGE_SIZE
            )
        }

        return when (response) {
            is Result.Success -> {
                val data = response.data.items ?: emptyList()
                LoadResult.Page(
                    data = data.filterNotNull(),
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (data.isEmpty()) null else currentPage + 1
                )
            }
            is Result.Failure -> {
                LoadResult.Error(response.exception)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition
    }
}
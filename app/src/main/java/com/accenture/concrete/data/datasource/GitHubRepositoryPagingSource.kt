package com.accenture.concrete.data.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.accenture.concrete.constant.ServiceConstants.LANGUAJE
import com.accenture.concrete.constant.ServiceConstants.PAGE_SIZE
import com.accenture.concrete.constant.ServiceConstants.STARS
import com.accenture.concrete.data.model.Item
import com.accenture.concrete.data.remote.ApiService
import com.google.gson.Gson
import javax.inject.Inject

class GitHubRepositoryPagingSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, Item>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {

            val currentPage = params.key ?: 1
            val response = apiService.getRepository(
                query = LANGUAJE,
                sort = STARS,
                page = currentPage,
                perPage = PAGE_SIZE
            )

            val data = response.body()?.items ?: emptyList()
            LoadResult.Page(
                data = data.filterNotNull(),
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (data.isEmpty()) null else currentPage + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition
    }
}
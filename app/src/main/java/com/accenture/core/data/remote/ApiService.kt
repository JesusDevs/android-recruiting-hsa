package com.accenture.core.data.remote

import com.accenture.core.app.constant.ServiceConstants.API_REPOSITORY

import com.accenture.core.app.constant.ServiceConstants.API_PULL
import com.accenture.core.app.constant.ServiceConstants.PAGE
import com.accenture.core.app.constant.ServiceConstants.PER_PAGE
import com.accenture.core.app.constant.ServiceConstants.QUERY_PARAMS
import com.accenture.core.app.constant.ServiceConstants.SORT
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.data.model.response.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path


interface ApiService {
    @GET(API_REPOSITORY)
    suspend fun getRepository(
        @Query(QUERY_PARAMS) query: String,
        @Query(SORT) sort: String,
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) perPage: Int
    ): Response<RepositoryResponse>

    @GET(API_PULL)
    fun getPullRepo(
        @Path("owner") owner: String?,
        @Path("repository") repo: String?,
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) perPage: Int
    ): Response<List<PullRequest>>
    @GET("repos/MisterBooo/LeetCodeAnimation/pulls")
    suspend fun getPullRequests(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int)
    : Response <List<PullRequest>>
}
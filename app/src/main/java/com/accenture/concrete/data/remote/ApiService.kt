package com.accenture.concrete.data.remote

import com.accenture.concrete.constant.ServiceConstants.API_REPOSITORY
import com.accenture.concrete.constant.ServiceConstants.PAGE
import com.accenture.concrete.constant.ServiceConstants.QUERY_PARAMS
import com.accenture.concrete.constant.ServiceConstants.SORT
import com.accenture.concrete.data.model.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET(API_REPOSITORY)
    suspend fun getRepository(
        @Query(QUERY_PARAMS) query: String,
        @Query(SORT) sort: String,
        @Query(PAGE) page: Int,
    ): List<Item>
}
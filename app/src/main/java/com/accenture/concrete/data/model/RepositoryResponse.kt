package com.accenture.concrete.data.model


import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,
    @SerializedName("items")
    val items: List<Item?>? = null,
    @SerializedName("total_count")
    val totalCount: Int? = null
)
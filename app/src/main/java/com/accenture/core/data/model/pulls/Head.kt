package com.accenture.core.data.model.pulls


import com.google.gson.annotations.SerializedName

data class Head(
    @SerializedName("label")
    val label: String?,
    @SerializedName("ref")
    val ref: String?,
    @SerializedName("repo")
    val repo: Repository?,
    @SerializedName("sha")
    val sha: String?,
    @SerializedName("user")
    val user: User?
)
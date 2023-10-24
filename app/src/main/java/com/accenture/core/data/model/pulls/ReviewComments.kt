package com.accenture.core.data.model.pulls


import com.google.gson.annotations.SerializedName

data class ReviewComments(
    @SerializedName("href")
    val href: String?
)
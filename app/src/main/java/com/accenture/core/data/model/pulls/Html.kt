package com.accenture.core.data.model.pulls


import com.google.gson.annotations.SerializedName

data class Html(
    @SerializedName("href")
    val href: String?
)
package com.accenture.core.data.model.pulls


import com.google.gson.annotations.SerializedName

data class Self(
    @SerializedName("href")
    val href: String?
)
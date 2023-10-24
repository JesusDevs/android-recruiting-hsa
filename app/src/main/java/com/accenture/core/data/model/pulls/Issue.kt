package com.accenture.core.data.model.pulls


import com.google.gson.annotations.SerializedName

data class Issue(
    @SerializedName("href")
    val href: String?
)
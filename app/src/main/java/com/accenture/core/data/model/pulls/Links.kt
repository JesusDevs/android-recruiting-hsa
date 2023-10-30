package com.accenture.core.data.model.pulls

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("comments")
    val comments: Link,
    @SerializedName("commits")
    val commits: Link,
    @SerializedName("html")
    val html: Link,
    @SerializedName("issue")
    val issue: Link,
    @SerializedName("review_comment")
    val reviewComment: Link,
    @SerializedName("review_comments")
    val reviewComments: Link,
    @SerializedName("self")
    val self: Link,
    @SerializedName("statuses")
    val statuses: Link
)
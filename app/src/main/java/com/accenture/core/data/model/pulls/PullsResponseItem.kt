package com.accenture.core.data.model.pulls


import com.google.gson.annotations.SerializedName

data class PullsResponseItem(
    @SerializedName("active_lock_reason")
    val activeLockReason: Any?,
    @SerializedName("assignee")
    val assignee: Any?,
    @SerializedName("assignees")
    val assignees: List<Any>?,
    @SerializedName("author_association")
    val authorAssociation: String?,
    @SerializedName("auto_merge")
    val autoMerge: Any?,
    @SerializedName("base")
    val base: Base?,
    @SerializedName("body")
    val body: String?,
    @SerializedName("closed_at")
    val closedAt: Any?,
    @SerializedName("comments_url")
    val commentsUrl: String?,
    @SerializedName("commits_url")
    val commitsUrl: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("diff_url")
    val diffUrl: String?,
    @SerializedName("draft")
    val draft: Boolean?,
    @SerializedName("head")
    val head: Head?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("issue_url")
    val issueUrl: String?,
    @SerializedName("labels")
    val labels: List<Any>?,
    @SerializedName("_links")
    val links: Links?,
    @SerializedName("locked")
    val locked: Boolean?,
    @SerializedName("merge_commit_sha")
    val mergeCommitSha: String?,
    @SerializedName("merged_at")
    val mergedAt: Any?,
    @SerializedName("milestone")
    val milestone: Any?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("patch_url")
    val patchUrl: String?,
    @SerializedName("requested_reviewers")
    val requestedReviewers: List<Any>?,
    @SerializedName("requested_teams")
    val requestedTeams: List<Any>?,
    @SerializedName("review_comment_url")
    val reviewCommentUrl: String?,
    @SerializedName("review_comments_url")
    val reviewCommentsUrl: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("statuses_url")
    val statusesUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("user")
    val user: User?
)
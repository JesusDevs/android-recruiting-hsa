package com.accenture.core.data.model.pulls

import com.accenture.core.data.model.pulls.Base
import com.accenture.core.data.model.pulls.Head
import com.accenture.core.data.model.pulls.Links
import com.accenture.core.data.model.pulls.User

data class PullRequest(
    val url: String,
    val id: Long,
    val node_id: String,
    val html_url: String,
    val diff_url: String,
    val patch_url: String,
    val issue_url: String,
    val number: Int,
    val state: String,
    val locked: Boolean,
    val title: String,
    val user: User,
    val body: String,
    val created_at: String,
    val updated_at: String,
    val closed_at: String?,
    val merged_at: String?,
    val merge_commit_sha: String,
    val assignee: Any?,
    val assignees: List<Any>,
    val requested_reviewers: List<Any>,
    val requested_teams: List<Any>,
    val labels: List<Any>,
    val milestone: Any?,
    val draft: Boolean,
    val commits_url: String,
    val review_comments_url: String,
    val review_comment_url: String,
    val comments_url: String,
    val statuses_url: String,
    val head: Head,
    val base: Base,
    val _links: Links,
    val author_association: String,
    val auto_merge: Any?,
    val active_lock_reason: Any?
)





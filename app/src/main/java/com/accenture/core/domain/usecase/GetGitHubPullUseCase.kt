package com.accenture.core.domain.usecase

import androidx.paging.PagingData
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.domain.model.Pulls
import com.accenture.core.domain.repository.GitHubRepositoryInterface
import kotlinx.coroutines.flow.Flow

class GetGitHubPullUseCase (
    private val repository: GitHubRepositoryInterface
) : BaseUseCase<Pulls, Flow<PagingData<PullRequest>>> {

    override suspend fun execute(input: Pulls): Flow<PagingData<PullRequest>> {
        return repository.getGitHubPulls(input)
    }

}

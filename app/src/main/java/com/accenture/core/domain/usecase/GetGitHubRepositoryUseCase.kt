package com.accenture.core.domain.usecase

import androidx.paging.PagingData
import com.accenture.core.data.model.response.Item
import com.accenture.core.domain.repository.GitHubRepositoryInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGitHubRepositoryUseCase @Inject constructor(
    private val repository: GitHubRepositoryInterface
) : BaseUseCase<Unit,Flow <PagingData<Item>>>  {

    override suspend fun execute(input: Unit): Flow<PagingData<Item>> {
        return repository.getGitHubRepository()
    }
}
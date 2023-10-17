package com.accenture.concrete.domain.usecase

import androidx.paging.PagingData
import com.accenture.concrete.data.model.Item
import com.accenture.concrete.data.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGitHubRepositoryUseCase @Inject constructor(
    private val repository: GitHubRepository
) : BaseUseCase<Unit,Flow <PagingData<Item>>>  {

    override suspend fun execute(input: Unit): Flow<PagingData<Item>> {
        return repository.getGitHubRepository()
    }
}
package com.accenture.core.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.accenture.core.data.model.response.Item
import com.accenture.core.domain.usecase.GetGitHubRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GitHubRepoHomeViewModel @Inject constructor(
    private val getGitHubUseCase: GetGitHubRepositoryUseCase
) : ViewModel() {

    private val _gitHubRepoState: MutableStateFlow<PagingData<Item>> = MutableStateFlow(value = PagingData.empty())
    val gitHubRepoState: MutableStateFlow<PagingData<Item>> get() = _gitHubRepoState

    init {
        viewModelScope.launch {
            getGitHubRepository()
        }
    }

    private suspend fun getGitHubRepository() {
        getGitHubUseCase.execute(Unit)
            .cachedIn(viewModelScope)
            .collect {
                _gitHubRepoState.value = it
            }
    }
}

package com.accenture.concrete.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.accenture.concrete.data.model.Item
import com.accenture.concrete.domain.usecase.GetGitHubRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GitHubRepoViewModel @Inject constructor(
    private val getGitHubUseCase: GetGitHubRepositoryUseCase
) : ViewModel() {

    private val _gitHubRepositoryState: MutableStateFlow<PagingData<Item>> = MutableStateFlow(value = PagingData.empty())
    val gitHubRepositoryState: MutableStateFlow<PagingData<Item>> get() = _gitHubRepositoryState

    init {
        viewModelScope.launch {
            getGitHubRepository()
        }
    }

    private suspend fun getGitHubRepository() {
        getGitHubUseCase.execute(Unit)
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect {
                _gitHubRepositoryState.value = it
            }
    }
}

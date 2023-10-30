package com.accenture.core.ui.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.accenture.core.data.model.pulls.PullRequest
import com.accenture.core.domain.model.Pulls
import com.accenture.core.domain.usecase.GetGitHubPullUseCase
import com.accenture.core.ui.navigation.NavArg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getGitHubUseCase: GetGitHubPullUseCase
) : ViewModel() {

    private val repoName: String = savedStateHandle.get<String>(NavArg.RepoName.key) ?: "Spoon-Knife"
    private val ownerLogin: String = savedStateHandle.get<String>(NavArg.OwnerLogin.key) ?: "octocat"



    private val _gitHubPullState: MutableStateFlow<PagingData<PullRequest>>
    = MutableStateFlow(value = PagingData.empty())
    val gitHubPullState: MutableStateFlow<PagingData<PullRequest>>
        get() = _gitHubPullState


     suspend fun getGitHubPull() {

        val pulls = Pulls(ownerLogin, repoName)
        getGitHubUseCase.execute(pulls)
            .cachedIn(viewModelScope)
            .flowOn(Dispatchers.IO)
            .collect {
                _gitHubPullState.value = it
            }
    }
}
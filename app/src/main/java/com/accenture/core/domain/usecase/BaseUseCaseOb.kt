package com.accenture.core.domain.usecase

import com.accenture.core.domain.model.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseUseCaseOb<T, V> {
    private var parameters: T? = null

    private val _operationState: MutableStateFlow<DataState<V>> =
        MutableStateFlow(DataState.Idle())
    val operationState: Flow<DataState<V>> = _operationState

    protected abstract suspend fun executeOnBackground(parameters: T? = null): V

    suspend fun execute(parameters: T? = null) {
        runCatching {
            this.parameters = parameters
            _operationState.value = DataState.Loading()
            executeOnBackground(parameters)
        }.onSuccess {
            _operationState.value = DataState.Success(it)
        }.onFailure {
            _operationState.value = DataState.Error(it.message ?: "Error Default")
        }
    }

    suspend fun retry() {
        execute(parameters)
    }
}
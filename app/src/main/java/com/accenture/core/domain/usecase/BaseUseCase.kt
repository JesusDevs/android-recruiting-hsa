package com.accenture.core.domain.usecase

interface BaseUseCase<In, Out>{
    suspend fun execute(input: In): Out
}
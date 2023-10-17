package com.accenture.concrete.domain.usecase

interface BaseUseCase<In, Out>{
    suspend fun execute(input: In): Out
}
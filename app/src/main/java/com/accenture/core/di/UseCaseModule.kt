package com.accenture.core.di

import com.accenture.core.data.repository.GitHubRepository
import com.accenture.core.domain.usecase.GetGitHubPullUseCase
import com.accenture.core.domain.usecase.GetGitHubRepositoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    fun providesGetGitHubRepoUseCase(
        movieRepository: GitHubRepository
    ): GetGitHubRepositoryUseCase {
        return GetGitHubRepositoryUseCase(movieRepository)
    }
    @Singleton
    @Provides
    fun providesGetGitHubPullsUseCase(
        movieRepository: GitHubRepository
    ): GetGitHubPullUseCase {
        return GetGitHubPullUseCase(movieRepository)
    }
}
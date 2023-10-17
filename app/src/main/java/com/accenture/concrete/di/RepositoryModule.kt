package com.accenture.concrete.di

import com.accenture.concrete.data.datasource.GitHubRepositoryPagingSource
import com.accenture.concrete.data.remote.ApiService
import com.accenture.concrete.data.repository.GitHubRepository
import com.accenture.concrete.domain.usecase.GetGitHubRepositoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideGitHubRepository(apiService: ApiService): GitHubRepository {
        return GitHubRepository(apiService)
    }
}
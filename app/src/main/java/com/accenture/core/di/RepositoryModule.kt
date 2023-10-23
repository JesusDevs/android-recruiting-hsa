package com.accenture.core.di

import com.accenture.core.data.remote.ApiService
import com.accenture.core.data.repository.GitHubRepository
import com.accenture.core.data.repository.datasource.GitHubRepositoryPagingSource
import com.accenture.core.domain.repository.GitHubRepositoryInterface
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
    fun provideGitHubRepository(apiService: ApiService): GitHubRepositoryInterface {
        return GitHubRepository(apiService)
    }
    @Provides
    @Singleton
    fun provideGitHubRepositoryPagingSource(apiService:ApiService ): GitHubRepositoryPagingSource {
        return GitHubRepositoryPagingSource(apiService)
    }

}
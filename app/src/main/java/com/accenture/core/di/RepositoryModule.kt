package com.accenture.core.di

import com.accenture.core.data.remote.ApiService
import com.accenture.core.data.repository.GitHubRepository
import com.accenture.core.data.repository.datasource.GitHubPagingSourceFactory
import com.accenture.core.data.repository.datasource.repo.GitHubRepositoryPagingSource
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
    fun provideGitHubRepository(gitHubPagingSourceFactory: GitHubPagingSourceFactory): GitHubRepositoryInterface {
        return GitHubRepository(gitHubPagingSourceFactory)
    }

    @Provides
    @Singleton
    fun provideGitHubPullPagingSourceFactory(apiService: ApiService): GitHubPagingSourceFactory {
        return GitHubPagingSourceFactory(apiService)
    }
}
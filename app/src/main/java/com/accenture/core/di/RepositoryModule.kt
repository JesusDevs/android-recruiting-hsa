package com.accenture.core.di

import com.accenture.core.data.remote.ApiService
import com.accenture.core.data.repository.GitHubRepository
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
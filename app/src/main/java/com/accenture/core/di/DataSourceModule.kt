package com.accenture.core.di

import com.accenture.core.data.datasource.GitHubRepositoryPagingSource
import com.accenture.core.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideGitHubRepositoryPagingSource(apiService:ApiService ): GitHubRepositoryPagingSource {
        return GitHubRepositoryPagingSource(apiService)
    }

}
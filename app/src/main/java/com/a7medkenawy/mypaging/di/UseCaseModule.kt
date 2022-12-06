package com.a7medkenawy.mypaging.di

import com.a7medkenawy.mypaging.domain.repository.ResponseRepository
import com.a7medkenawy.mypaging.domain.usecase.ResponseUseCase
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
    fun provideResponseUseCase(responseRepository: ResponseRepository) =
        ResponseUseCase(responseRepository)
}
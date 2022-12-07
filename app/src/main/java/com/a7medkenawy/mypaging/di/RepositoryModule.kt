package com.a7medkenawy.mypaging.di

import com.a7medkenawy.mypaging.data.ResponseRepositoryImpl
import com.a7medkenawy.mypaging.data.database.ImagesDao
import com.a7medkenawy.mypaging.data.network.PixabayApiInterface
import com.a7medkenawy.mypaging.domain.repository.ResponseRepository
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
    fun provideRepository(pixabayApiInterface: PixabayApiInterface,imagesDao: ImagesDao): ResponseRepository =
        ResponseRepositoryImpl(pixabayApiInterface,imagesDao)
}
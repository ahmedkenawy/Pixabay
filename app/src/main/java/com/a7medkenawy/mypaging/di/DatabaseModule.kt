package com.a7medkenawy.mypaging.di

import android.content.Context
import androidx.room.Room
import com.a7medkenawy.mypaging.data.database.ImagesDatabase
import com.a7medkenawy.mypaging.utils.Constants.IMAGES_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    //room database instance
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ImagesDatabase::class.java,
            IMAGES_DATABASE
        ).build()

    //instance from dao
    @Singleton
    @Provides
    fun provideDao(database: ImagesDatabase) = database.getDao()

}
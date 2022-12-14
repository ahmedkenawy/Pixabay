package com.a7medkenawy.mypaging.domain.repository

import com.a7medkenawy.mypaging.domain.model.ImageResponse
import com.a7medkenawy.mypaging.domain.model.databaseentity.ImagesResponseEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ResponseRepository {

    suspend fun getImagesFromApi(page: Int): Response<ImageResponse>

    suspend fun insertAllImages(imagesResponseEntity: ImagesResponseEntity)

    fun getAllImages(): Flow<List<ImagesResponseEntity>>

//    suspend fun deleteAllImages()
}
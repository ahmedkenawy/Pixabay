package com.a7medkenawy.mypaging.domain.repository

import com.a7medkenawy.mypaging.domain.model.ImageResponse
import retrofit2.Response

interface ResponseRepository {

    suspend fun getImagesFromApi(page: Int): Response<ImageResponse>
}
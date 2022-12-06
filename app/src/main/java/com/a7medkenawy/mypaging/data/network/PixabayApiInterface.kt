package com.a7medkenawy.mypaging.data.network

import com.a7medkenawy.mypaging.domain.model.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApiInterface {

    @GET("api/")
    suspend fun getImagesFromApi(
        @Query("page") page: Int,
        @Query("key") key: String = "20100002-346c79d6eee3f381b6574bcaf",
    ): Response<ImageResponse>

}
package com.a7medkenawy.mypaging.data

import com.a7medkenawy.mypaging.data.network.PixabayApiInterface
import com.a7medkenawy.mypaging.domain.repository.ResponseRepository
import javax.inject.Inject

class ResponseRepositoryImpl @Inject constructor(
    val apiResponse: PixabayApiInterface,
) : ResponseRepository {

    override suspend fun getImagesFromApi(page: Int) = apiResponse.getImagesFromApi(page)


}
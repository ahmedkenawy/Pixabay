package com.a7medkenawy.mypaging.domain.usecase

import com.a7medkenawy.mypaging.domain.model.ImageResponse
import com.a7medkenawy.mypaging.domain.repository.ResponseRepository
import retrofit2.Response
import javax.inject.Inject

class ResponseUseCase @Inject constructor(
    val responseRepository: ResponseRepository,
) {
    suspend fun getImagesFromApi(page:Int):Response<ImageResponse> =
        responseRepository.getImagesFromApi(page)

}
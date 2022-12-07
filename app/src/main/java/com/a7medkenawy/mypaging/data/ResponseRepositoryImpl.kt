package com.a7medkenawy.mypaging.data

import com.a7medkenawy.mypaging.data.database.ImagesDao
import com.a7medkenawy.mypaging.data.network.PixabayApiInterface
import com.a7medkenawy.mypaging.domain.model.databaseentity.ImagesResponseEntity
import com.a7medkenawy.mypaging.domain.repository.ResponseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ResponseRepositoryImpl @Inject constructor(
    val apiResponse: PixabayApiInterface,
    val imagesDao: ImagesDao,
) : ResponseRepository {

    override suspend fun getImagesFromApi(page: Int) = apiResponse.getImagesFromApi(page)

    override suspend fun insertAllImages(imagesResponseEntity: ImagesResponseEntity) {
        imagesDao.insertAllImages(imagesResponseEntity)
    }

    override fun getAllImages(): Flow<List<ImagesResponseEntity>> = imagesDao.getAllImages()

//    override suspend fun deleteAllImages() {
//        imagesDao.deleteAllImages()
//    }


}
package com.a7medkenawy.mypaging.data.database

import androidx.room.*
import com.a7medkenawy.mypaging.domain.model.Hit
import com.a7medkenawy.mypaging.domain.model.ImageResponse
import com.a7medkenawy.mypaging.domain.model.databaseentity.ImagesResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ImagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImages(imagesResponseEntity: ImagesResponseEntity)

    @Query("select * from images_table order by id asc")
    fun getAllImages(): Flow<List<ImagesResponseEntity>>

//    @Query("delete from images_table")
//    suspend fun deleteAllImages()
}
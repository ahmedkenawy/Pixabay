package com.a7medkenawy.mypaging.domain.model.databaseentity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.a7medkenawy.mypaging.domain.model.ImageResponse

@Entity(tableName = "images_table")
class ImagesResponseEntity (
    var imageResponse: ImageResponse
        ){
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
package com.a7medkenawy.mypaging.data.database

import androidx.room.TypeConverter
import com.a7medkenawy.mypaging.domain.model.ImageResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImagesTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(imageResponse: ImageResponse): String {
        return gson.toJson(imageResponse)
    }

    @TypeConverter
    fun stringToImageResponse(data: String): ImageResponse {
        var listType = object : TypeToken<ImageResponse>() {}.type
        return gson.fromJson(data, listType)
    }
}
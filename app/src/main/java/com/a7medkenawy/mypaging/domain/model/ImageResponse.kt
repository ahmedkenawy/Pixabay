package com.a7medkenawy.mypaging.domain.model


import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("hits")
    val hits: List<Hit>
)
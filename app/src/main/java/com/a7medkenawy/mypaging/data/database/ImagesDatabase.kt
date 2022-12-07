package com.a7medkenawy.mypaging.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.a7medkenawy.mypaging.domain.model.Hit
import com.a7medkenawy.mypaging.domain.model.databaseentity.ImagesResponseEntity

@Database(entities = [ImagesResponseEntity::class], version = 1, exportSchema = false)
@TypeConverters(ImagesTypeConverter::class)
abstract class ImagesDatabase : RoomDatabase() {
    abstract fun getDao(): ImagesDao
}
package com.ppb.mamamapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ppb.mamamapp.data.local.entity.FavoriteEntity

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
abstract class MealsFavoriteDatabase : RoomDatabase() {

    abstract fun mealsDao(): MealFavoriteDao
}
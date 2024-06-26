package com.ppb.mamamapp.domain.usecase

import com.ppb.mamamapp.data.local.entity.FavoriteEntity
import com.ppb.mamamapp.data.remote.network.Result
import com.ppb.mamamapp.domain.model.AreaMeals
import com.ppb.mamamapp.domain.model.CategoryMeals
import com.ppb.mamamapp.domain.model.DetailMeals
import kotlinx.coroutines.flow.Flow

interface MealsUseCase {

    fun getCategories(): Flow<Result<List<CategoryMeals>>>

    fun getAreas(): Flow<Result<List<AreaMeals>>>

    fun getMealsByCategory(category: String): Flow<Result<List<DetailMeals>>>

    fun getMealsByArea(area: String): Flow<Result<List<DetailMeals>>>

    fun getMealsByName(name: String): Flow<Result<List<DetailMeals>>>

    fun getMealsById(id: String): Flow<Result<List<DetailMeals>>>

    suspend fun insertFavorite(favorite: FavoriteEntity)

    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    fun checkMeal(id: String): Flow<List<FavoriteEntity>>

    suspend fun deleteFavorite(favorite: FavoriteEntity)
}
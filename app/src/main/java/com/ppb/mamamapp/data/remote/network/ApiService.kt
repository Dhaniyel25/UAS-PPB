package com.ppb.mamamapp.data.remote.network

import com.ppb.mamamapp.data.remote.response.MealsAreaResponse
import com.ppb.mamamapp.data.remote.response.MealsCategoryResponse
import com.ppb.mamamapp.data.remote.response.MealsListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("list.php?c=list")
    suspend fun getCategories(): MealsCategoryResponse

    @GET("list.php?a=list")
    suspend fun getAreas(): MealsAreaResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealsListResponse

    @GET("filter.php")
    suspend fun getMealsByArea(@Query("a") area: String): MealsListResponse

    @GET("search.php")
    suspend fun getMealsByName(@Query("s") name: String): MealsListResponse

    @GET("lookup.php")
    suspend fun getMealsById(@Query("i") id: String): MealsListResponse
}
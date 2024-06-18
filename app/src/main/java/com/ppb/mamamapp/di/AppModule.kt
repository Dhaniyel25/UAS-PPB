package com.ppb.mamamapp.di

import com.ppb.mamamapp.data.remote.MealsRepository
import com.ppb.mamamapp.domain.usecase.MealsInteractor
import com.ppb.mamamapp.domain.usecase.MealsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMealsUseCase(mealsRepository: MealsRepository): MealsUseCase =
        MealsInteractor(mealsRepository)
}
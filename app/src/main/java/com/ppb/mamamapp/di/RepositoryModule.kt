package com.ppb.mamamapp.di

import com.ppb.mamamapp.data.remote.MealsRepository
import com.ppb.mamamapp.domain.repository.IMealsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(mealsRepository: MealsRepository) : IMealsRepository
}
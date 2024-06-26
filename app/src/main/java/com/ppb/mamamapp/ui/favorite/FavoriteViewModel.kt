package com.ppb.mamamapp.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ppb.mamamapp.domain.usecase.MealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(mealsUseCase: MealsUseCase) : ViewModel() {

    val getAllFavorites = mealsUseCase.getAllFavorites().asLiveData()
}
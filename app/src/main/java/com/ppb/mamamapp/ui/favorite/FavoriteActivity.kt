package com.ppb.mamamapp.ui.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ppb.mamamapp.R
import com.ppb.mamamapp.adapter.FavoriteMealsAdapter
import com.ppb.mamamapp.databinding.ActivityFavoriteBinding
import com.ppb.mamamapp.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var mealsAdapter: FavoriteMealsAdapter
    private val favViewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupData()
    }

    private fun setupView() {
        supportActionBar?.apply {
            title = getString(R.string.favorite_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupData() {
        mealsAdapter = FavoriteMealsAdapter {
            Intent(this@FavoriteActivity, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_DATA, it.idMeal)
                startActivity(this)
            }
        }

        favViewModel.getAllFavorites.observe(this@FavoriteActivity) { meal ->
            if (!meal.isNullOrEmpty()) {
                mealsAdapter.submitList(meal)
                favIsNotEmpty()
            } else {
                favIsEmpty()
            }
        }

        binding.rvMeals.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = mealsAdapter
        }
    }

    private fun favIsEmpty() {
        binding.apply {
            rvMeals.visibility = View.GONE
            tvEmpty.visibility = View.VISIBLE
        }
    }

    private fun favIsNotEmpty() {
        binding.apply {
            rvMeals.visibility = View.VISIBLE
            tvEmpty.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
package com.hammad.growiser.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hammad.growiser.GroWiserApp
import com.hammad.growiser.R
import com.hammad.growiser.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GroWiserApp.get().appComponent.inject(this)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigationListener()
    }

    private fun initNavigationListener() {
        val host = supportFragmentManager.findFragmentById(R.id.homeContainer) as NavHostFragment
        controller = host.navController

        controller.addOnDestinationChangedListener { _, _, _ ->
        }
    }
}

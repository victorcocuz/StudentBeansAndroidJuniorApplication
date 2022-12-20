package com.example.studentbeansandroidjuniorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.studentbeansandroidjuniorapplication.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            // Set Appbar and navController
            setSupportActionBar(lToolbarMain)
            navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
            NavigationUI.setupActionBarWithNavController(this@MainActivity, navController, mainDrawerLayout)
            appBarConfiguration = AppBarConfiguration(navController.graph, mainDrawerLayout)
        }

        navController.addOnDestinationChangedListener { _: NavController, nd: NavDestination, _: Bundle? ->
            when (nd.id) {
                R.id.LoginFragment -> supportActionBar?.setDisplayShowTitleEnabled(false)
                else -> supportActionBar?.setDisplayShowTitleEnabled(true)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }
}
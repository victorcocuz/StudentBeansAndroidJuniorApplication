package com.example.studentbeansandroidjuniorapplication

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.studentbeansandroidjuniorapplication.databinding.ActivityMainBinding
import com.example.studentbeansandroidjuniorapplication.utils.removeFocusAndHideKeyboard

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            // Setup AppBar and navController
            setSupportActionBar(toolbarMain)
            navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
            NavigationUI.setupActionBarWithNavController(this@MainActivity, navController)
            appBarConfiguration = AppBarConfiguration(navController.graph)

            navController.addOnDestinationChangedListener { _: NavController, nd: NavDestination, _: Bundle? ->
                when (nd.id) {
                    R.id.LoginFragment -> supportActionBar?.setDisplayShowTitleEnabled(false)
                    else -> supportActionBar?.setDisplayShowTitleEnabled(true)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean { // Remove focus from edit text on outside click
        currentFocus?.removeFocusAndHideKeyboard(this, event)
        return super.dispatchTouchEvent(event)
    }
}
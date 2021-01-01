package com.jdemaagd.navpatterns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.jdemaagd.navpatterns.databinding.ActivityMainBinding

// Being used as host for fragments
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // NavigationController has a NavigationUI Library:
        // that can integrate with the ActionBar to implement correct behavior for up button
        val navController = this.findNavController(R.id.navHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        // return NavigationUI.navigateUp(navController, appBarConfiguration)
        return navController.navigateUp()
    }
}

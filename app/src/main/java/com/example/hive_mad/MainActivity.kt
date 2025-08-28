package com.example.hive_mad

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.hive_mad.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            bottomNav = findViewById(R.id.bottomNav)

            // Ensure the bar sits above gesture nav bars
            ViewCompat.setOnApplyWindowInsetsListener(bottomNav) { v, insets ->
                val bottom = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
                v.setPadding(v.paddingLeft, v.paddingTop, v.paddingRight, bottom)
                insets
            }

            bottomNav.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> switchTo(HomeFragment(), "home")
                    R.id.menu_workout -> switchTo(WorkoutFragment(), "workout")
                    R.id.menu_stats -> switchTo(StatsFragment(), "stats")
                    R.id.menu_hydration -> switchTo(HydrationFragment(), "hydration")
                    R.id.menu_profile -> switchTo(ProfileFragment(), "profile")
                }
                true
            }

            if (savedInstanceState == null) {
                bottomNav.selectedItemId = R.id.menu_home
            }
        } catch (e: Exception) {
            // Log the error for debugging
            e.printStackTrace()
            // Handle gracefully - maybe show an error message or finish the activity
        }
    }

    private fun switchTo(fragment: Fragment, tag: String) {
        try {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.navHost, fragment, tag)
                .commitAllowingStateLoss()
        } catch (e: Exception) {
            // Log the error or handle gracefully
            e.printStackTrace()
        }
    }

    // From Home fragment buttons
    fun goToWorkout(view: View) { bottomNav.selectedItemId = R.id.menu_workout }
    fun goToStats(view: View) { bottomNav.selectedItemId = R.id.menu_stats }
}
package com.example.hive_mad

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WorkoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
    }

    fun openHome(view: View) = startActivity(Intent(this, MainActivity::class.java))
    fun openStats(view: View) = startActivity(Intent(this, StatsActivity::class.java))
    fun openHydration(view: View) = startActivity(Intent(this, HydrationActivity::class.java))
    fun openProfile(view: View) = startActivity(Intent(this, ProfileActivity::class.java))
    fun openWorkout(view: View) { /* already here */ }
}
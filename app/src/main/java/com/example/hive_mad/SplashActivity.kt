package com.example.hive_mad

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val prefs = getSharedPreferences("hydrafit_prefs", MODE_PRIVATE)
        val onboarded = prefs.getBoolean("onboarded", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (onboarded) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, OnboardingActivity::class.java))
            }
            finish()
        }, 1200)
    }
}
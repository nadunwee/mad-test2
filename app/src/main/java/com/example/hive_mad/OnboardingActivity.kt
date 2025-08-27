package com.example.hive_mad

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {

    private var page = 0
    private lateinit var flipper: ViewFlipper
    private lateinit var tvTitle: TextView
    private lateinit var tvSub: TextView
    private lateinit var dot1: TextView
    private lateinit var dot2: TextView
    private lateinit var dot3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        flipper = findViewById(R.id.onboardFlipper)
        tvTitle = findViewById(R.id.onboardTitle)
        tvSub = findViewById(R.id.onboardSubtitle)
        dot1 = findViewById(R.id.dot1)
        dot2 = findViewById(R.id.dot2)
        dot3 = findViewById(R.id.dot3)

        updatePage(0)

        findViewById<TextView>(R.id.btnSkip).setOnClickListener {
            completeAndStart()
        }
        findViewById<TextView>(R.id.btnNext).setOnClickListener {
            if (page < 2) {
                updatePage(page + 1)
            } else {
                completeAndStart()
            }
        }
    }

    private fun updatePage(newPage: Int) {
        page = newPage
        flipper.displayedChild = page
        when (page) {
            0 -> {
                tvTitle.setText(R.string.onboard_title_1)
                tvSub.setText(R.string.onboard_sub_1)
                dot1.setBackgroundResource(R.drawable.dot_active)
                dot2.setBackgroundResource(R.drawable.dot_inactive)
                dot3.setBackgroundResource(R.drawable.dot_inactive)
            }
            1 -> {
                tvTitle.setText(R.string.onboard_title_2)
                tvSub.setText(R.string.onboard_sub_2)
                dot1.setBackgroundResource(R.drawable.dot_inactive)
                dot2.setBackgroundResource(R.drawable.dot_active)
                dot3.setBackgroundResource(R.drawable.dot_inactive)
            }
            2 -> {
                tvTitle.setText(R.string.onboard_title_3)
                tvSub.setText(R.string.onboard_sub_3)
                dot1.setBackgroundResource(R.drawable.dot_inactive)
                dot2.setBackgroundResource(R.drawable.dot_inactive)
                dot3.setBackgroundResource(R.drawable.dot_active)
            }
        }
        val nextBtn = findViewById<TextView>(R.id.btnNext)
        nextBtn.setText(if (page == 2) R.string.onboard_get_started else R.string.onboard_next)
    }

    private fun completeAndStart() {
        val prefs = getSharedPreferences("hydrafit_prefs", MODE_PRIVATE)
        prefs.edit().putBoolean("onboarded", true).apply()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
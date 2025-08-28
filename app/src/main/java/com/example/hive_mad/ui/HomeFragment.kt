package com.example.hive_mad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hive_mad.MainActivity
import com.example.hive_mad.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        
        // Set up button click listeners
        view.findViewById<View>(R.id.btnStartWorkout)?.setOnClickListener {
            (activity as? MainActivity)?.goToWorkout(it)
        }
        
        view.findViewById<View>(R.id.btnViewStats)?.setOnClickListener {
            (activity as? MainActivity)?.goToStats(it)
        }
        
        return view
    }
}
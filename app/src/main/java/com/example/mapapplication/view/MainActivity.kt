package com.example.mapapplication.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mapapplication.R
import com.example.mapapplication.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMapFragment()
    }

    private fun addMapFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.map_fragment_container, MapsFragment()).commit()
    }
}
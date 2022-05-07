package com.example.composerecipeapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composerecipeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    lateinit var someRandomeString: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}
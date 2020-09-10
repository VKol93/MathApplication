package com.vk.mathaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this, R.id.fragment)
        yearButton.setOnClickListener {
            navController.navigate(R.id.fragmentYear)
        }
        mathButton.setOnClickListener {
            navController.navigate(R.id.fragmentMath)
        }
        triviaButton.setOnClickListener {
            navController.navigate(R.id.fragmentTrivia)
        }
        dataButton.setOnClickListener {
            navController.navigate(R.id.fragmentData)
        }
    }


}
package com.fcenesiz.shopping_list_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fcenesiz.shopping_list_testing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
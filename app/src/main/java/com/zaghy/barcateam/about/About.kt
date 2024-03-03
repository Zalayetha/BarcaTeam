package com.zaghy.barcateam.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.zaghy.barcateam.R
import com.zaghy.barcateam.databinding.ActivityAboutBinding

class About : AppCompatActivity() {
    private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }




}
package com.zaghy.barcateam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zaghy.barcateam.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
//    private lateinit var binding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this@SplashScreen,MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}
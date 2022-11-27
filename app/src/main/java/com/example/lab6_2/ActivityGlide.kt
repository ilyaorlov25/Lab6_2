package com.example.lab6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class ActivityGlide : AppCompatActivity() {
    private val urlStream = "https://img1.akspic.ru/crops/4/0/4/0/7/170404/170404-porshe-porsche_911_gt3_r_991-legkovyye_avtomobili-sportkar-vapkar-3840x2160.jpg"
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            Log.d("Button", "is pressed")
            imageView = findViewById(R.id.imageView)
            it.isClickable = false
            Glide.with(this).load(urlStream).into(imageView)
        }
    }
}
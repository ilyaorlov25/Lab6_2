package com.example.lab6_2

import android.app.Application
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class MainActivity : AppCompatActivity() {
    private lateinit var executorService: Future<*>
    private val urlStream = "https://img1.akspic.ru/crops/4/0/4/0/7/170404/170404-porshe-porsche_911_gt3_r_991-legkovyye_avtomobili-sportkar-vapkar-3840x2160.jpg"
    private lateinit var  imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            Log.d("Button", "is pressed")
            imageView = findViewById(R.id.imageView)
            it.isClickable = false
            executorService = (application as ExecutorApp).executor.submit {
                val urlImage = URL(urlStream)
                val imageBitmap = BitmapFactory.decodeStream(urlImage.openConnection().getInputStream())
                runOnUiThread {
                    imageView.setImageBitmap(imageBitmap)
                }
                Log.d("Image", "is downloaded")
            }
        }
    }

    class ExecutorApp : Application() {
        val executor: ExecutorService = Executors.newSingleThreadExecutor()
    }
}
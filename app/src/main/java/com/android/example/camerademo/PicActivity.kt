package com.android.example.camerademo

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_pic.*

class PicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_pic)

        var imgPath = intent.getStringExtra("imgUri")
        var bitmap = BitmapFactory.decodeFile(imgPath)
        image_view.setImageBitmap(bitmap)
    }

}
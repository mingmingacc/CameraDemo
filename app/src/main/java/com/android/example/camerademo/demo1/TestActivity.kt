package com.android.example.camerademo.demo1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.example.camerademo.R
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        clickMe.setOnClickListener {
            PictureSelector.create(this@TestActivity)
                    .openCamera(PictureMimeType.ofImage())
                    .enableCrop(true)
                    .showCropFrame(true)
                    .showCropGrid(true)
                    .hideBottomControls(false)
                    .freeStyleCropEnabled(true)
                    .selectionMode(PictureConfig.SINGLE)
                    .forResult(CameraActivity2.REQUEST_CODE_ALBUM)
        }
    }
}

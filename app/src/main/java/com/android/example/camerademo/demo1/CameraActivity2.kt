package com.android.example.camerademo.demo1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.android.example.camerademo.PicActivity
import com.android.example.camerademo.R
import com.android.example.camerademo.util.UriUtils
import com.android.example.camerademo.util.log
import com.android.example.camerademo.util.toast
import com.cs.camerademo.camera2.Camera2Helper
import kotlinx.android.synthetic.main.activity_camera2.*

class CameraActivity2 : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE_CAPTURE = 3
        const val REQUEST_CODE_CAPTURE_CROP = 4
        const val REQUEST_CODE_ALBUM = 5
        const val REQUEST_CODE_VIDEO = 6
    }

    private lateinit var mCamera2Helper: Camera2Helper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_camera2)


        mCamera2Helper = Camera2Helper(this, textureView)

        btnTakePic.setOnClickListener { mCamera2Helper.takePic() }
        ivExchange.setOnClickListener { mCamera2Helper.exchangeCamera() }
        camera_iv_history.setOnClickListener { toast("打开历史纪录") }
        camera_iv_back.setOnClickListener { finish() }
        ivSetting.setOnClickListener { gotoGallery() }
    }

    //打开系统相册
    private fun gotoGallery() {
        var intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_ALBUM)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCamera2Helper.releaseCamera()
        mCamera2Helper.releaseThread()
    }

    override fun onResume() {
        super.onResume()
        mCamera2Helper.startPreview()
    }

    override fun onPause() {
        super.onPause()
        mCamera2Helper.stopPreview()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_ALBUM -> {

                    data?.let {
                        log("选择完图片:" + it.data)
                        // 第一种拿到图片去裁剪
                        //第二种把图片传到其他Activity展示
                        var uri: Uri = it.data
                        val intent = Intent(this@CameraActivity2, PicActivity::class.java)
                        intent.putExtra("imgUri", UriUtils.getPath(this@CameraActivity2, uri))
                        startActivity(intent)
                    }

                }
            }
        }
    }
}
package com.android.example.camerademo

import android.app.Activity
import android.graphics.RectF
import android.hardware.Camera
import android.view.SurfaceHolder
import android.view.SurfaceView

class CameraHelper(activity: Activity, surfaceView: SurfaceView) : Camera.PreviewCallback {

    private var mCamera: Camera? = null //Camera对象
    private lateinit var mParameters: Camera.Parameters //Camera对象的参数

    private var mSurfaceView: SurfaceView = surfaceView //用于预览的SurfaceView对象

    var mSurfaceHolder: SurfaceHolder? = null //SurfaceHolder对象

    private var mActivity: Activity = activity

    private var mCallBack: CallBack? = null
    override fun onPreviewFrame(p0: ByteArray?, p1: Camera?) {

    }

    interface CallBack {
        fun onPreviewFrame(data: ByteArray?)
        fun onTakePic(data: ByteArray?)
        fun onDaceDetect(faces: ArrayList<RectF>)
    }

    init {
        mSurfaceHolder = mSurfaceView.holder
        init()
    }

    private fun init() {
        mSurfaceHolder?.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
            }

            override fun surfaceDestroyed(p0: SurfaceHolder?) {
            }

            override fun surfaceCreated(p0: SurfaceHolder?) {
                if (mCamera == null) {
//                    openCamera(m)
                }
//                startPreview()
            }

        })
    }

}
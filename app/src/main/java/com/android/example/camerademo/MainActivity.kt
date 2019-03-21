package com.android.example.camerademo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.example.camerademo.demo1.CameraActivity
import com.hjq.permissions.OnPermission
import kotlinx.android.synthetic.main.activity_main.*
import com.hjq.permissions.XXPermissions
import com.android.example.camerademo.demo1.CameraActivity2
import com.hjq.permissions.Permission


class MainActivity : AppCompatActivity() ,OnPermission{
    override fun noPermission(denied: MutableList<String>?, quick: Boolean) {
    }

    override fun hasPermission(granted: MutableList<String>?, isAll: Boolean) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestFilePermission()
        initView()
    }

    private fun initView() {
        btCameraRecord.setOnClickListener {
            startActivity(Intent(this@MainActivity, CameraActivity::class.java))
        }

        btCamera2.setOnClickListener {
            val intent = Intent(this, CameraActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun requestFilePermission() {
        XXPermissions.with(this)
                .permission(Permission.CAMERA)
                .permission(Permission.Group.STORAGE)
                .request(this)
    }
}
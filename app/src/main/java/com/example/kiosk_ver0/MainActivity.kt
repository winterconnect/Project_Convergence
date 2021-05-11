package com.example.kiosk_ver0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent;
import android.os.Handler;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 3초 지연후 이동하는 로딩
        var handler = Handler()
        handler.postDelayed({
            var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        },3000)

    }
}
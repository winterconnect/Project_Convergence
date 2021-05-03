package com.example.kiosk_ver0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var order = findViewById<TextView>(R.id.textView)

        order.setOnClickListener {
            val nextIntent = Intent(this, MenuActivity::class.java)
            startActivity(nextIntent)
        }
    }
}
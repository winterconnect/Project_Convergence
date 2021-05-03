package com.example.kiosk_ver0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val Adapter = com.example.kiosk_ver0.Fragment.PagerAdapter(supportFragmentManager)
        
        // 뷰 페이저에 어댑터 연결
        view_pager.adapter = Adapter
        view_pager.currentItem=0
        // 탭 레아아웃에 뷰페이저 연결
        tabs.setupWithViewPager(view_pager)
        // 탭뷰 각각 이름 만들기
        val feel=arrayOf("단품","세트","음료")
        for(i in 0..2)
            tabs.getTabAt(i)?.setText(feel[i])


    }

    }

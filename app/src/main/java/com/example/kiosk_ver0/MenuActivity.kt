package com.example.kiosk_ver0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kiosk_ver0.Fragment.Page1Fragment
import com.example.kiosk_ver0.Fragment.Page2Fragment
import com.example.kiosk_ver0.Fragment.PagerAdapter
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    var cart = ArrayList<MenuListData>()  // 장바구니

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
        val tab=arrayOf("버거","음료")
        for(i in 0..1)
            tabs.getTabAt(i)?.text = tab[i]

        // btnCartIn을 눌렀을 때, menuCheckBox가 눌린 메뉴 정보를 CartListActivity로 넘겨주기
        btnCartIn.setOnClickListener {
            val adapter = view_pager.adapter as PagerAdapter
            when(view_pager.currentItem) {
                0 -> {
                    // adapter.currentFragment를 특정 Fragment로 변환 후 처리
                    val fragment = adapter.currentFragment  as Page1Fragment

                    for (i in 0 until fragment.items.size) {
                        var count = 0
                        var index = 0
                        for (j in 0 until cart.size) {
                            if (cart[j].name == fragment.items[i].name) {
                                count += 1
                                index = j
                            }
                        }
                        if(fragment.items[i].checkbox) {
                            if (count == 0) {
                                cart.plusAssign(fragment.items[i])
                            } else {
                                cart[index].quantity = fragment.items[i].quantity
                            }
                        }
                    }
                    Log.i("MenuActivity", cart.toString())
                }
                1 -> {
                    // adapter.currentFragment를 특정 Fragment로 변환 후 처리
                    val fragment = adapter.currentFragment  as Page2Fragment

                    for (i in 0 until fragment.items.size) {
                        var count = 0
                        var index = 0
                        for (j in 0 until cart.size) {
                            if (cart[j].name == fragment.items[i].name) {
                                count += 1
                                index = j
                            }
                        }
                        if(fragment.items[i].checkbox) {
                            if (count == 0) {
                                cart.plusAssign(fragment.items[i])
                            } else {
                                cart[index].quantity = fragment.items[i].quantity
                            }
                        }
                    }
                    Log.i("MenuActivity", cart.toString())
                }
            }


        }

        btnCartList.setOnClickListener {
            val nextIntent = Intent(this, CartListActivity::class.java)
            nextIntent.putExtra("cart", cart)
            startActivity(nextIntent)
        }

    }




}

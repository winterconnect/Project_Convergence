package com.example.kiosk_ver0

import android.content.Intent
import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_cart_list.*

class CartListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_list)

        val cart = intent.getSerializableExtra("cart") as ArrayList<MenuListData>
        Log.i("CartListActivity", cart.toString())

        rv_cart_list.adapter = CartListAdapter(cart,txtTotalPrice)
        rv_cart_list.layoutManager = GridLayoutManager(this,1)

        btnBack.setOnClickListener {
            finish()
//
//            val nextIntent = Intent(this, MenuActivity::class.java)
//            startActivity(nextIntent)
        }

        btnPay.setOnClickListener {
            val nextIntent = Intent(this, OrderListActivity::class.java)
            val list = ArrayList<OrderListData>()
            for(item in cart) {
                list += OrderListData(item.name, item.quantity)
            }
            // order목록을 서버로 보내기
            // 카트 비우기
            nextIntent.putExtra("order", list)
            startActivity(nextIntent)
        }

        // 총액
        var totalprice = 0
        for (item in cart) {
            totalprice += item.price * item.quantity
        }
        txtTotalPrice.text = "${NumberFormat.getInstance().format(totalprice)} 원"
    }

}
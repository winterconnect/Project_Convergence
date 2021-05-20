package com.example.kiosk_ver0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_order_list.*

class OrderListActivity : AppCompatActivity() {

//    var items = mutableListOf<OrderListData>()
//    init {
//        items.plusAssign(OrderListData("주문 번호: 1", "메뉴: 빅맥", "조리 중"))
//    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)

        // 서버에서 주문목록+주문번호+상태 가져오기
        val order = intent.getSerializableExtra("order") as ArrayList<OrderListData>
        Log.i("OrderListActivity", order.toString())

        rv_order_list.adapter = OrderListAdapter(order)
        rv_order_list.layoutManager = GridLayoutManager(this,1)

        var home = findViewById<TextView>(R.id.btnHome)

        home.setOnClickListener {
            val nextIntent = Intent(this, HomeActivity::class.java)
            startActivity(nextIntent)
        }
    }

}
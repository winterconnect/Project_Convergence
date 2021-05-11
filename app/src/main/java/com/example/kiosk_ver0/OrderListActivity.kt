package com.example.kiosk_ver0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_order_list.*
import org.jetbrains.anko.longToast

class OrderListActivity : AppCompatActivity() {
    companion object {
        val KEY_DATA = "DATA"
    }

    // 추후에 DB에서 불러오기
    var items = mutableListOf<OrderListData>()
    init {
        for(i in 1..3) {
            items.plusAssign(OrderListData("주문 번호: $i", "메뉴: 빅맥", "조리 중"))
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)

        rv_order_list.adapter = OrderListAdapter(items, ::onItemClick)
        rv_order_list.layoutManager = GridLayoutManager(this,1)

        var home = findViewById<TextView>(R.id.btnHome)

        home.setOnClickListener {
            val nextIntent = Intent(this, HomeActivity::class.java)
            startActivity(nextIntent)
        }
    }

    fun onItemClick(pos: Int) {
        val data = items[pos]
//        longToast(data.toString())
//        startActivity<DetailActivity>(
//            "DATA" to data
//        )
    }

}
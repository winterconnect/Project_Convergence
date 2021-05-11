package com.example.kiosk_ver0

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_order_list.view.*

class OrderListAdapter(val items: List<OrderListData>, val onItemClick: (Int)->Unit): RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder>() {
    val TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_list, parent, false)
        return OrderListViewHolder(view)
    }

    // 데이터의 개수 리턴
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: OrderListViewHolder, position: Int) {
        items[position].let { it ->
            with(holder) {
                orderNumber.text = it.number
                orderMenu.text = it.menu
                orderStatus.text = it.status
            }
        }
    }

    inner class OrderListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderNumber = itemView.orderNumber
        val orderMenu = itemView.orderMenu
        val orderStatus = itemView.orderStatus

        init {
            itemView.setOnClickListener {
                val pos = adapterPosition   // 현재 ViewHolder가 몇번째 index인지 알 수 있는 속성
                if (pos != RecyclerView.NO_POSITION) {
                    Log.d(TAG, "Item Clicked - $pos")
                    // Activity의 OnItemClick() 호출
                    onItemClick(pos)
                }
            }
        }
    }


}
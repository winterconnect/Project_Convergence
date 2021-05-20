package com.example.kiosk_ver0

import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_cart_list.*
import kotlinx.android.synthetic.main.item_cart_list.view.*

class CartListAdapter(val items: ArrayList<MenuListData>, val txtTotalPrice: TextView):  RecyclerView.Adapter<CartListAdapter.CartListViewHolder>() {

    val TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_list, parent, false)
        return CartListViewHolder(view)
    }

    // 데이터의 개수 리턴
    override fun getItemCount() = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CartListViewHolder, position: Int) {
        items[position].let { it ->
            with(holder) {
                cartImage.setImageResource(it.image)
                cartName.text = it.name
                cartQuantity.text = "수량: ${it.quantity}"
                cartPrice.text = "금액: ${NumberFormat.getInstance().format(it.price)} 원"
            }
        }
    }

    inner class CartListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cartImage = itemView.cartImage
        val cartName = itemView.cartName
        val cartQuantity = itemView.cartQuantity
        val cartPrice = itemView.cartPrice
        val btnDelete = itemView.txtDelete

        init {
            itemView.setOnClickListener {
                val pos = adapterPosition   // 현재 ViewHolder가 몇번째 index인지 알 수 있는 속성
                if (pos != RecyclerView.NO_POSITION) {
                    Log.d(TAG, "Item Clicked - $pos")
                }
            }

            btnDelete.setOnClickListener {
                val pos = adapterPosition
                items.removeAt(pos)
                this@CartListAdapter.notifyDataSetChanged()
                Log.i(TAG, items.toString())

                // 총액
                var totalprice = 0
                for (item in items) {
                    totalprice += item.price * item.quantity
                }
                txtTotalPrice.text = "${NumberFormat.getInstance().format(totalprice)} 원"
            }

        }
    }

}
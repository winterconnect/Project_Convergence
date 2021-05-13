package com.example.kiosk_ver0

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_menu_list1.view.*

class MenuListAdapter(val items: List<MenuListData>, val onItemClick: (Int)->Unit): RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder>() {

//    val TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_list1, parent, false)
        Log.w("-----------------------------------------------", view.toString())
        return MenuListViewHolder(view)
    }

    // 데이터의 개수 리턴
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MenuListViewHolder, position: Int) {
        items[position].let { it ->
            with(holder) {
                menuCheckBox.isChecked = it.checkbox
                menuImage.setImageResource(it.image)
                menuName.text = it.name
                menuQuantity.text = it.quantity.toString()
                menuPrice.text = it.price.toString()
            }
        }
    }

    inner class MenuListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuCheckBox = itemView.menuCheckBox
        val menuImage = itemView.menuImage
        val menuName = itemView.menuName
        val menuQuantity = itemView.menuQuantity
        val menuPrice = itemView.menuPrice
        val btnMinus = itemView.btnMinus
        val btnPlus = itemView.btnPlus

        init {
            val pos = adapterPosition
            itemView.setOnClickListener {
                menuCheckBox.toggle()
//                val pos = adapterPosition
                   // 현재 ViewHolder가 몇번째 index인지 알 수 있는 속성
                if (pos != RecyclerView.NO_POSITION) {
                    items[pos].checkbox = menuCheckBox.isChecked
                }
            }

//            btnMinus.setOnClickListener {
//                items[pos].quantity -= 1
//            }
//            btnPlus.setOnClickListener {
//                items[pos].quantity += 1
//            }

        }



    }

}
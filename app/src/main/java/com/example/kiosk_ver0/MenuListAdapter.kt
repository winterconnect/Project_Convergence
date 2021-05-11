package com.example.kiosk_ver0

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_menu_list1.view.*

class MenuListAdapter(val items: List<MenuListData>, val onItemClick: (Int)->Unit): RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder>() {

    val TAG = javaClass.simpleName

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
                //btnCartIn(activity_menu.xml)을 눌렀을 때, menuCheckBox가 눌린 메뉴 정보(이름, 가격)만 CartListActivity로 넘겨주기
//                menuCheckBox.setOnCheckedChangeListener {
//
//                }
                menuImage.setImageResource(it.image)
                menuName.text = it.name
                menuPrice.text = it.price
            }
        }
    }

    inner class MenuListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuCheckBox = itemView.menuCheckBox
        val menuImage = itemView.menuImage
        val menuName = itemView.menuName
        val menuPrice = itemView.menuPrice

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
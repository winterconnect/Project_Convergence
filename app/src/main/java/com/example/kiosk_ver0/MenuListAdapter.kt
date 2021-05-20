package com.example.kiosk_ver0

import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_menu_list.view.*

class MenuListAdapter(val items: List<MenuListData>, val onItemClick: (Int)->Unit): RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder>() {

//    val TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_list, parent, false)
//        Log.w("-----------------------------------------------", view.toString())
        return MenuListViewHolder(view)
    }

    // 데이터의 개수 리턴
    override fun getItemCount() = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MenuListViewHolder, position: Int) {
        items[position].let { it ->
            with(holder) {
                menuCheckBox.isChecked = it.checkbox
                menuImage.setImageResource(it.image)
                menuName.text = it.name
                menuQuantity.text = it.quantity.toString()
                menuPrice.text = "${NumberFormat.getInstance().format(it.price)} 원"
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

//            Log.d("MenuListViewHolder", "ViewHodler init")
            itemView.setOnClickListener {
                menuCheckBox.toggle()
                val pos = adapterPosition
                   // 현재 ViewHolder가 몇번째 index인지 알 수 있는 속성
                if (pos != RecyclerView.NO_POSITION) {
                    items[pos].checkbox = menuCheckBox.isChecked
                    if(menuCheckBox.isChecked) {    // checkbox 체크할 때 0이면 1개 증가 (0이 아닌 경우 + 버튼 누를때 체크 자동으로 됨)
                        items[pos].quantity += 1
                        menuQuantity.text = items[pos].quantity.toString()
                    } else {                        // 체크 안할 때 수량 0으로 변경
                        items[pos].quantity = 0
                        menuQuantity.text = items[pos].quantity.toString()
                    }
                }
//                Log.d("Adapter", "check ${items[pos]}")
            }

            btnMinus.setOnClickListener {
//                Log.d("Adapter", "minus")
                val pos = adapterPosition
                if(items[pos].quantity ==0 ) {
                    return@setOnClickListener
                }
                items[pos].quantity -= 1
                menuQuantity.text = items[pos].quantity.toString()
                if(items[pos].quantity == 0) {  // 수량이 0개이면 체크박스 자동으로 해제
                    menuCheckBox.toggle()
                    items[pos].checkbox = menuCheckBox.isChecked
                }
            }
            btnPlus.setOnClickListener {
//                Log.d("Adapter", "plus")
                val pos = adapterPosition
                if(!menuCheckBox.isChecked) {   // 체크가 안되어있다면 +누르면서 체크
                    menuCheckBox.toggle()
                    items[pos].checkbox = menuCheckBox.isChecked
                }
                items[pos].quantity += 1
                menuQuantity.text = items[pos].quantity.toString()
            }

        }



    }

}
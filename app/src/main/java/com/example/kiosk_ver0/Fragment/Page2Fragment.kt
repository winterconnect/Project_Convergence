package com.example.kiosk_ver0.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kiosk_ver0.*

class Page2Fragment : Fragment() {

    var items = mutableListOf<MenuListData>()   // 메뉴
    init {
        items.plusAssign(MenuListData(false, R.drawable.menu_cocacola, "코카 콜라", 0, 2100))
        items.plusAssign(MenuListData(false, R.drawable.menu_sprite, "사이다", 0, 2100))
    }

    // 뷰 생성 <onCreate다음에 호출됨>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_page2, container, false)
        val rv = root.findViewById<RecyclerView>(R.id.rv_menu_list2)
        rv.adapter = MenuListAdapter(items, ::onItemClick)
        rv.layoutManager = GridLayoutManager(activity,2)

        return root
    }

    fun onItemClick(pos: Int) {
        val data = items[pos]
    }

    // 뷰 생성이 완료되면 호출되는 메소드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        section_label.text=arguments?.let{
//            it.getInt(num).toString()
//        }
//        imageView.setImageResource(R.drawable.sad)
    }

    companion object {
        private const val num = "num"

        @JvmStatic
        fun newInstance(Number: Int): Page2Fragment {
            return Page2Fragment().apply {
                arguments = Bundle().apply {
                    putInt(num, Number)
                }
            }
        }
    }
}
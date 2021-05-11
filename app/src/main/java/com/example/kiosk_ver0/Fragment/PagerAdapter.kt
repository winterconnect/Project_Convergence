package com.example.kiosk_ver0.Fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    // 프래그먼트 담는 리스트
    private val items= ArrayList<Fragment>()

    init{
    // 프래그먼트 생성 후 리스트에 저장
        items.add(Page1Fragment.newInstance(1))
        items.add(Page2Fragment.newInstance(2))
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }

}
package com.example.kiosk_ver0

import java.io.Serializable

data class MenuListData(var checkbox:Boolean, val image:Int, val name:String, var quantity:Int, val price:Int) : Serializable
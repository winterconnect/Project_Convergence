package com.example.kiosk_ver0

import java.io.Serializable

// Serializable: 인터페이스(생성자 호출 안함)
data class OrderListData(val number: String, val menu: String, val status: String) : Serializable
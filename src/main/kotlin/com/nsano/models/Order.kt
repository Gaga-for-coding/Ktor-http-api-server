package com.nsano.models

import kotlinx.serialization.Serializable

val orderStorage = listOf(Order("2022-18-12", listOf(
    OrderItem("Fried Rice with Fish", 2, 50.00),
    OrderItem("Fufu with palm soup", 3, 67.00),
    OrderItem("Club Beer", 10, 12.99),
    OrderItem("Vody", 7, 16.99)
)), Order("2022-18-13", listOf(
    OrderItem("Fried Rice with Chicken", 1, 50.00),
    OrderItem("Fufu with light soup", 5, 77.00),
    OrderItem("Star Beer", 13, 12.99),
    OrderItem("Coke", 2, 19.99)
))
)

@Serializable
data class Order(val number: String, val content: List<OrderItem>)

@Serializable
data class OrderItem(val item: String, val amount: Int, val price: Double)

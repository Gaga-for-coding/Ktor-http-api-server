package com.nsano

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals


class OrderRouteTest{
    @Test
    fun testGetOrder() = testApplication {
        val response = client.get("/order/2022-18-12")
        assertEquals("""{"number":"2022-18-12","content":[{"item":"Fried Rice with Fish","amount":2,"price":50.0},{"item":"Fufu with palm soup","amount":3,"price":67.0},{"item":"Club Beer","amount":10,"price":12.99},{"item":"Vody","amount":7,"price":16.99}]}""", response.bodyAsText())

        assertEquals(HttpStatusCode.OK, response.status)
    }
}
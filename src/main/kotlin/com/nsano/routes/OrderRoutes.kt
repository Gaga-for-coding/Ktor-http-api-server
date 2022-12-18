package com.nsano.routes

import com.nsano.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.orderRouting(){
    get("/orders"){
        if(orderStorage.isNotEmpty()){
            call.respond(orderStorage)
        }
    }

    get("{id?}"){
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val order = orderStorage.find { it.number == id } ?: return@get call.respondText("Not Found", status = HttpStatusCode.NotFound)
        call.respond(order)
    }
}

fun Route.totalizeRouting(){
    get("/order/{id?}/total"){
        val id = call.parameters["id"] ?: return@get call.respondText("Id not found", status = HttpStatusCode.BadRequest)
        val order = orderStorage.find { it.number == id } ?: return@get call.respondText("Not Found", status = HttpStatusCode.NotFound)
        val total = order.content.sumOf { it.price * it.amount }
        call.respond(total)
    }
}
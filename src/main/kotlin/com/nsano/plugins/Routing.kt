package com.nsano.plugins

import com.nsano.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        orderRouting()
        totalizeRouting()
    }
}

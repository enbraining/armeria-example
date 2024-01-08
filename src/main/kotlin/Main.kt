package org.example

import com.linecorp.armeria.common.HttpResponse
import com.linecorp.armeria.server.Server
import org.slf4j.LoggerFactory

class Main
fun main() {
    var logger = LoggerFactory.getLogger(Main::class.java)

    var server = Server.builder()
        .http(8080)
        .service("/") {
                      rtx, req -> HttpResponse.of("Hello")
        }.build()

    server.closeOnJvmShutdown()

    server.start().join()
}
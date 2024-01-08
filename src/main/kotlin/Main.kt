package org.example

import com.linecorp.armeria.server.Server
import com.linecorp.armeria.server.docs.DocService
import org.slf4j.LoggerFactory

class Main
fun main() {
    var logger = LoggerFactory.getLogger(Main::class.java)

    val server = Server.builder()
        .http(8080)
        .annotatedService(UserService())
        .serviceUnder("/docs", getDoc())
        .build()

    server.closeOnJvmShutdown()

    server.start().join()
}

fun getDoc(): DocService{
    return DocService.builder()
        .exampleRequests(UserService::class.java,
            "user", // Name of service method
            "{\"title\":\"My first user\", \"content\":\"Hello Armeria!\"}")
        .build()
}
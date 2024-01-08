package org.example

import com.linecorp.armeria.server.annotation.Post
import java.util.concurrent.ConcurrentHashMap
import com.linecorp.armeria.common.HttpResponse

class UserService {
    val users: Map<Int, User> = ConcurrentHashMap<Int, User>()

    @Post("/user")
    fun signUp(user: User): HttpResponse{
        return HttpResponse.ofJson(user)
    }
}

class User {
    var email: String? = null
    var password: String? = null

    constructor()

    constructor(email: String, password: String){
        this.email = email
        this.password = password
    }

    override fun toString(): String {
        return "User(email=$email, password=$password)"
    }
}


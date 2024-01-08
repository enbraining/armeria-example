package org.example

import com.linecorp.armeria.server.annotation.Post
import java.util.concurrent.ConcurrentHashMap

class UserService {
    val users: Map<Int, User> = ConcurrentHashMap<Int, User>()

    @Post("/user")
    fun signUp(user: User): String{
        return user.toString()
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


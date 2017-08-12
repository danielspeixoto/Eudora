package com.hackathonix.eudora.model

import com.hackathonix.eudora.R
import io.reactivex.Single

/**
 * Created by daniel on 8/11/17.
 */
object UserModel {

    var users : ArrayList<User> = arrayListOf()

    var currentUser: User? = null
        get private set
    init {
        users.add(User("d@gmail.com", "1", "Daniel", 5000.0 , 2000.0, image = R.drawable.joao_marcos))
    }


    fun logIn(email: String, password: String): Single<User> {
        return Single.create<User> { subscriber ->
            var user : User? = null
            users.forEach({
                if(it.email == email && it.password == password) {
                    currentUser = it
                    subscriber.onSuccess(it)
                }
            })
//            user = User(email, password, "Daniel", 5000.0 , 2000.0, image = R.drawable.joao_marcos)
//            users.add(user)
//            currentUser = user
//            subscriber.onSuccess(user)
        }
    }


    fun logIn(user: User) = logIn(user.email!!, user.password!!)

    fun logOut() {
        currentUser = null
    }


    val isLogged: Boolean
        get() = currentUser != null
}
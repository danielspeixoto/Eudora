package com.hackathonix.eudora.model

import android.content.Context
import com.hackathonix.eudora.R
import com.hackathonix.eudora.util.string
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by daniel on 8/11/17.
 */
object UserModel {

    var users : ArrayList<User> = arrayListOf()

    var currentUser: User? = null
        get private set
    init {
        users.add(User("d@gmail.com", "1", "Daniel", 5000.0 , 2000.0, image = R.drawable.apontador_soul_duo))
        //todo remove
        currentUser = users.get(0)
    }


    fun logIn(username: String, password: String): Single<User> {
        return Single.create<User> { subscriber ->
            var user = User(username, password)
            users.add(user)
            currentUser = user
            subscriber.onSuccess(user)
        }
    }


    fun logIn(user: User) = logIn(user.email!!, user.password!!)

    fun logOut() {
        currentUser = null
    }


    val isLogged: Boolean
        get() = currentUser != null
}
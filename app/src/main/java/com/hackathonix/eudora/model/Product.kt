package com.hackathonix.eudora.model

import java.io.Serializable

/**
 * Created by daniel on 8/11/17.
 */
data class Product(var name : String, var image : Int, var price : Double, var isAvailable : Boolean = false, var canTry : Boolean = false) : Serializable
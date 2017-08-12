package com.hackathonix.eudora.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by daniel on 8/11/17.
 */
data class Product(var name : String, var image : Int, var price : Double, var isAvailable : Boolean = false, var category:Int, var canTry : Boolean = false) : Serializable
package com.hackathonix.eudora.model

/**
 * Created by daniel on 8/11/17.
 */
object ProductModel {

    var products : ArrayList<Product> = arrayListOf()

    fun insert(product : Product) {
        products.add(product)
    }


}
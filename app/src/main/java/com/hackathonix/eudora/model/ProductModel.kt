package com.hackathonix.eudora.model

import com.hackathonix.eudora.R

/**
 * Created by daniel on 8/11/17.
 */
object ProductModel {

    var products : ArrayList<Product> = arrayListOf()

    init {
        products.add(Product(
                "KISS ME BATOM MATE ROSA CORAJOSA",
                R.drawable.kiss_me_batom_mate_rosa_corajosa,
               16.99)
        )
    }

    fun insert(product : Product) {
        products.add(product)
    }


}
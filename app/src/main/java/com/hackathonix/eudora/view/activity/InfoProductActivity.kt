package com.hackathonix.eudora.view.activity

import android.os.Bundle
import com.hackathonix.eudora.model.Product
import org.jetbrains.anko.centerHorizontally
import org.jetbrains.anko.imageView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.verticalLayout

/**
 * Created by daniel on 8/11/17.
 */
//TODO implement
class InfoProductActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var product = intent.getSerializableExtra("product") as Product
        verticalLayout {
            relativeLayout {
                imageView(product.image).lparams(500, 500) {
                    centerHorizontally()
                }
            }

        }
    }
}
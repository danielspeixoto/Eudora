package com.hackathonix.eudora.view.activity

import android.os.Bundle
import com.hackathonix.eudora.model.Client
import com.hackathonix.eudora.model.Product
import org.jetbrains.anko.centerHorizontally
import org.jetbrains.anko.imageView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.verticalLayout

/**
 * Created by dcandrade on 8/12/17.
 */

class MyClientsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var client = intent.getSerializableExtra("client") as Client
        verticalLayout {
            relativeLayout {
                imageView(client.picture).lparams(500, 500) {
                    centerHorizontally()
                }
            }

        }
    }
}
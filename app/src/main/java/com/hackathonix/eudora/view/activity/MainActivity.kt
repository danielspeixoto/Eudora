package com.hackathonix.eudora.view.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import com.hackathonix.eudora.R
import org.jetbrains.anko.*

/**
 * Created by daniel on 8/11/17.
 */
class MainActivity : BaseActivity() {

    lateinit var image : ImageView
    lateinit var thread : Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            lparams(width = matchParent, height = matchParent)
            image = imageView().lparams(width = matchParent, height = matchParent)
            backgroundColor = Color.rgb(82,44,132)
        }
        image.setImageResource(R.drawable.purple)
        var pics = arrayOf( R.drawable.eudora, R.drawable.eu_sonho, R.drawable.eu_quero, R.drawable.eu_posso)
        thread = Thread(object : Runnable {
            override fun run() {
                Thread.sleep(500)
                for(i in 0 .. pics.size - 1) {
                    this@MainActivity.runOnUiThread({
                        image.setImageResource(pics[i])
                    })
                    Thread.sleep(1000)
                }
                this@MainActivity.runOnUiThread({
                    startActivity<LoginActivity>()
                    finish()
                })
            }
        })
        thread.start()
    }
}
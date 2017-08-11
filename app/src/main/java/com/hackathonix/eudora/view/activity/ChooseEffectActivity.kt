
package com.hackathonix.eudora.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import com.hackathonix.eudora.util.IMakeEffect
import com.hackathonix.eudora.model.RedEffect
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.onClick
import org.jetbrains.anko.verticalLayout

/**
 * Created by daniel on 8/10/17.
 */
class ChooseEffectActivity  : AppCompatActivity() {

    lateinit var layout: LinearLayout
    lateinit var bitmap : Bitmap
    lateinit var effect : IMakeEffect

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = verticalLayout {
            lparams(width = matchParent, height = matchParent)
            onClick {
//                var intent = Intent(applicationContext, FaceActivity::class.java)
//                intent.putExtra("effect", RedEffect())
//                startActivity(intent)
            }
        }
        var intent = Intent(applicationContext, FaceActivity::class.java)
        intent.putExtra("effect", RedEffect())
        startActivity(intent)

    }
}

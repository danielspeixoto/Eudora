
package com.hackathonix.eudora

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
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
        effect = intent.getSerializableExtra("effect") as IMakeEffect
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

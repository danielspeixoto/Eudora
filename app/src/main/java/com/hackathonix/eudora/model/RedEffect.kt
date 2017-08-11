package com.hackathonix.eudora.model

import android.graphics.Bitmap
import android.graphics.Color
import com.hackathonix.eudora.util.IMakeEffect
import java.io.Serializable
import java.lang.Math.min

/**
 * Created by daniel on 8/10/17.
 */
class RedEffect: Serializable, IMakeEffect() {

    init {
        name = "Vermelho"
    }


    override fun doRefactor(bitmap: Bitmap, x: Int, y: Int) {
        var colour = bitmap.getPixel(x,y)
        val red = Color.red(colour)
        val blue = Color.blue(colour)
        val green = Color.green(colour)
        val alpha = Color.alpha(colour)
        bitmap.setPixel(x ,y, Color.argb(alpha, Math.min((red * 1.05), 255.0).toInt(), green, blue))
    }
}
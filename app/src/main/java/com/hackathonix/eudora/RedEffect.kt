package com.hackathonix.eudora

import android.graphics.Bitmap
import android.graphics.Color
import java.io.Serializable

/**
 * Created by daniel on 8/10/17.
 */
class RedEffect: Serializable, IMakeEffect {


    override fun doRefactor(bitmap: Bitmap, x: Int, y: Int) {
        var colour = bitmap.getPixel(x,y)
        val red = Color.red(colour)
        val blue = Color.blue(colour)
        val green = Color.green(colour)
        val alpha = Color.alpha(colour)
        bitmap.setPixel(x ,y, Color.argb(alpha, (red * 1.2).toInt(), green, blue))
    }
}
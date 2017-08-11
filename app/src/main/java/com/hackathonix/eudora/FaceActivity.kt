package com.hackathonix.eudora

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.content.Intent
import android.graphics.Bitmap
import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*


class FaceActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1

    lateinit var layout: LinearLayout
    lateinit var bitmap : Bitmap
    lateinit var effect : IMakeEffect

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = verticalLayout {
            lparams(width = matchParent, height = matchParent)
        }
        layout.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                var newBitmap = bitmap.copy(bitmap.config, true)
                var xProp = bitmap.width.toFloat() / layout.width
                var x = ((layout.left - p1!!.x) * -xProp).toInt()
                var y = ((layout.top - p1!!.y)* -xProp).toInt()
                var radius = 3
                for(i in -radius .. radius) {
                    for(j in -radius .. radius) {
                        if(x + j - i > 0 && x + j - i < newBitmap.width && y + i > 0 && y + i < newBitmap.height) {
                            effect.doRefactor(newBitmap, x + j - i, y + i)
                        }
                    }
                }
                bitmap = newBitmap
                layout.background = BitmapDrawable(getResources(), newBitmap)
                return false;
            }
        })
        dispatchTakePictureIntent()
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val extras = data!!.getExtras()
            var imageBitmap = extras.get("data") as Bitmap
            layout.background = BitmapDrawable(getResources(), imageBitmap)
            bitmap = imageBitmap
//            image.setImageBitmap(imageBitmap)
        }
    }
}

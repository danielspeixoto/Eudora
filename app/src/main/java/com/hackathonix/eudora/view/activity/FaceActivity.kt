package com.hackathonix.eudora.view.activity

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.widget.ImageView
import com.hackathonix.eudora.R
import com.hackathonix.eudora.R.drawable.purple
import com.hackathonix.eudora.R.string.save
import com.hackathonix.eudora.util.IMakeEffect
import com.hackathonix.eudora.util.PARAM_LAYOUT
import org.jetbrains.anko.*


class FaceActivity : BaseActivity() {

    val REQUEST_IMAGE_CAPTURE = 1

    lateinit var layout: ImageView
    lateinit var bitmap : android.graphics.Bitmap
    lateinit var effect : IMakeEffect

    @android.annotation.SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        effect = getIntent().getSerializableExtra("effect") as IMakeEffect
        verticalLayout {
            backgroundColor = gold
            relativeLayout {
                layout = imageView {
//                    padding = 10
//                    backgroundColor = gold
                    scaleType = ImageView.ScaleType.FIT_CENTER
                }.lparams(width = matchParent, height = 1400) {
                    margin = 90
                    topMargin = 0
                    topPadding = 0
                    bottomMargin = 20
                }
            }
            relativeLayout {
                // photo again or save
                var save = imageView{

                }.lparams(80, 80) {
                    alignParentLeft()
                    leftMargin = 220                }
                save.setImageResource(R.drawable.ic_save)

                var camera = imageView {
                    onClick {
                        dispatchTakePictureIntent()
                    }
                }.lparams(80, 80) {
                    alignParentRight()
                    rightMargin = 220                }
                camera.setImageResource(R.mipmap.ic_camera)
            }.lparams(width = matchParent)
//            textView(effect.name) {
//                textColor = Color.WHITE
//                textSize = (PARAM_LAYOUT * 4).toFloat()
//            }.lparams(width = wrapContent) {
//                centerHorizontally()
//                padding = 40
//                below(layout)
//            }
        }
        layout.setOnTouchListener(object : android.view.View.OnTouchListener {
            override fun onTouch(p0: android.view.View?, p1: android.view.MotionEvent?): Boolean {
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
                layout.setImageBitmap(newBitmap)
                return false;
            }
        })
        dispatchTakePictureIntent()
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = android.content.Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: android.content.Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == android.app.Activity.RESULT_OK) {
            val extras = data!!.getExtras()
            var imageBitmap = extras.get("data") as android.graphics.Bitmap
            bitmap = imageBitmap
            layout.setImageBitmap(imageBitmap)
        }
    }
}

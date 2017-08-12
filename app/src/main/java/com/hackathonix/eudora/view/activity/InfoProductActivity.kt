package com.hackathonix.eudora.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.hackathonix.eudora.model.Product
import com.hackathonix.eudora.model.RedEffect
import com.hackathonix.eudora.util.PARAM_LAYOUT
import org.jetbrains.anko.*
import android.widget.CompoundButton



/**
 * Created by daniel on 8/11/17.
 */
//TODO implement
class InfoProductActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var product = intent.getSerializableExtra("product") as Product
        relativeLayout {
            verticalLayout {
                padding = 50
                relativeLayout {
                    var image = imageView().lparams() {
                        centerHorizontally()
                    }
                    image.setImageResource(product.image)
                }.lparams(width = matchParent, height = 900) {
                    bottomPadding = 50
                }
                textView(product.name) {
                    textSize = (PARAM_LAYOUT * 2).toFloat()
                    textColor = gold
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }
                textView("R$" + product.price) {
                    textSize = (PARAM_LAYOUT * 2).toFloat()
                    padding = 50
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }
                var swt = switch {
                    padding = 50
                    text = "Disponivel no catálogo"
                }
                swt.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener { //This line has the error
                    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                        //TODO Consertar manter alterações no valor
                        product.isAvailable = !product.isAvailable
                    }
                })

                if(product.isAvailable) {
                    swt.isChecked = true
                }
                if(product.canTry) {
                    button("Experimente") {
                        backgroundColor = gold
                        textColor = purple
                        onClick {
                            var intent = Intent(applicationContext, FaceActivity::class.java)
                            intent.putExtra("effect", RedEffect())
                            startActivity(intent)
                        }
                    }.lparams(width = matchParent)
                }
            }.lparams {
                centerHorizontally()
            }
        }

    }
}
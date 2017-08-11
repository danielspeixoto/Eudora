package com.hackathonix.eudora.view.activity

import android.graphics.Color
import android.os.Bundle
import com.hackathonix.eudora.R
import com.hackathonix.eudora.view.activity.custom.editField
import org.jetbrains.anko.*

/**
 * Created by daniel on 8/11/17.
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var purple = Color.rgb(82,44,132)
       // var gold = Color.rgb(,,)
        relativeLayout {
            backgroundColor = purple
            verticalLayout {
                imageView {
                    imageResource = R.drawable.btn_facebook
                }
                editField {
                    backgroundColor = purple
                    hint = "Email"
                }
                editField {
                    backgroundColor = purple
                    hint = "Senha"
                }
            }.lparams(width = matchParent) {
                centerInParent()
                leftMargin = 50
                rightMargin = leftMargin
            }
            relativeLayout {
                textView("Cadastre-se") {

                }.lparams {
                    alignParentLeft()
                }
                button {
                    text = "Entrar"
                }.lparams {
                    alignParentRight()
                }
            }
        }
    }
}
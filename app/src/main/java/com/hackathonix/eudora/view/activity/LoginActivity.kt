package com.hackathonix.eudora.view.activity

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.InputType
import android.view.inputmethod.EditorInfo
import com.hackathonix.eudora.R
import com.hackathonix.eudora.R.drawable.purple
import com.hackathonix.eudora.model.UserModel
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.custom.EditField
import com.hackathonix.eudora.view.activity.custom.editField
import org.jetbrains.anko.*

/**
 * Created by daniel on 8/11/17.
 */
class LoginActivity : BaseActivity() {

    lateinit var email : EditField
    lateinit var password : EditField

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            backgroundColor = purple
            verticalLayout {
                relativeLayout {
                    imageView {
                        imageResource = R.drawable.logo
                    }.lparams(width = 200, height = 200) {
                        bottomMargin = 200
                        centerHorizontally()
                    }
                }.lparams(width = matchParent)
                verticalLayout {
                    email = editField {
                        textColor = purple
                        hint = "Email"
                        inputType = InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
                    }.lparams(width = matchParent) {
                        bottomMargin = 30
                    }
                    email.getBackground().mutate().setColorFilter(getResources().getColor(R.color.golden_eu), PorterDuff.Mode.SRC_ATOP);
                    password = editField {
                        textColor = purple
                        hint = "Senha"
                        inputType = EditorInfo.TYPE_CLASS_TEXT or EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD
                    }.lparams(width = matchParent) {
                        bottomMargin = 60
                    }
                    password.getBackground().mutate().setColorFilter(getResources().getColor(R.color.golden_eu), PorterDuff.Mode.SRC_ATOP);
                }.lparams(width = matchParent) {
                    bottomPadding = 90
                    topPadding = bottomPadding
                }

                relativeLayout {

                    textView("Cadastre-se") {
                        textColor = gold
                        textSize = (PARAM_LAYOUT * 2).toFloat()
                        padding = 20
                    }.lparams {
                        alignParentLeft()
                    }
                    button {
                        text = "Entrar"
                        backgroundColor = gold
                        textColor = purple
                        padding = PARAM_LAYOUT * 2
                        onClick {
                            UserModel.logIn(email.text.toString(), password.text.toString()).subscribe( { usr ->
                                startActivity<HomeActivity>()
                            })
                        }
                    }.lparams {
                        alignParentRight()
                    }
                }.lparams {
                    margin = 100
                }
            }.lparams(width = matchParent) {
                centerInParent()
                leftMargin = 50
                rightMargin = leftMargin
            }

        }
    }
}
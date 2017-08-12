package com.hackathonix.eudora.view.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.hackathonix.eudora.model.*
import com.hackathonix.eudora.util.Message
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.custom.tagList
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.nestedScrollView

/**
 * Created by daniel on 8/11/17.
 */
class GoalsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var user = UserModel.currentUser!!
        nestedScrollView {
            lparams(matchParent, matchParent)
            verticalLayout {
                textView("Faltam R$" + (user.goal - user.money).toInt() + " para atingir a sua meta") {
                    textColor = purple
                    textSize = (PARAM_LAYOUT * 2.5).toFloat()
                    padding = (PARAM_LAYOUT * 2)
                    topPadding = (PARAM_LAYOUT * 12)
                    bottomPadding = (PARAM_LAYOUT * 18)
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }

                textView("Combos Arrasa-Meta") {
                    textColor = purple
                    textSize = (PARAM_LAYOUT * 2.5).toFloat()
                    padding = (PARAM_LAYOUT * 2)
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    bottomPadding = (PARAM_LAYOUT * 5)
                    setTypeface(null, Typeface.BOLD);
                }
                var list = Stock.getInstance().bestSellerByCategory(Category.BODY_N_BATH, 3)
                var price = 0.0
                list.forEach({
                        price += it.price
                    }
                )
                var list2 = Stock.getInstance().bestSellerByCategory(Category.ACCESSORIES, 1)
                var price2 = 0.0
                list2.forEach({
                        price2 += it.price
                    }
                )
                relativeLayout() {
                    padding = 50
                    button() {
                        backgroundColor = Color.TRANSPARENT
                        textColor = gold
                        text = "R$" + price
                        onClick {
                            Message.data = list as ArrayList<Product>
                            startActivity<ProductGoalActivity>()
                        }
                    }.lparams {
                        leftMargin = 100
                        alignParentLeft()

                    }
                    button() {
                        backgroundColor = Color.TRANSPARENT
                        textColor = gold
                        text = "R$" + price2
                        onClick {
                            Message.data = list2 as ArrayList<Product>
                            startActivity<ProductGoalActivity>()
                        }
                    }.lparams {
                        rightMargin = 100
                        alignParentRight()

                    }
                }.lparams(width = matchParent) {
                    bottomPadding = 100
                }
                tagList {
                    edit.hint= "Preciso"
                    kind = 0
                    user.needs.forEach {
                        adpt.addItem(Link(it, Runnable {}))
                    }

                }.lparams {
                    bottomMargin = 70
                }

                tagList {
                    edit.hint= "Sonhos"
                    kind = 1
                    user.dreams.forEach {
                        adpt.addItem(Link(it, Runnable {}))
                    }
                }
            }.lparams(height = 1920, width = matchParent)
        }
    }
}
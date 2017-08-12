package com.hackathonix.eudora.view.activity.custom

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.hackathonix.eudora.R
import com.hackathonix.eudora.model.Link
import com.hackathonix.eudora.model.UserModel
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.BaseActivity
import com.hackathonix.eudora.view.recycler.adapter.LinksAdapter
import com.hackathonix.eudora.view.recycler.adapter.WishesAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by daniel on 8/11/17.
 */
class TagList(ctx: Context) : LinearLayout(ctx) {

    lateinit var edit : EditField

    var str = ""
    var list : RecyclerView
    var adpt = WishesAdapter(ctx)
    var kind : Int = 0

    init {
        orientation = LinearLayout.VERTICAL

        relativeLayout {
            edit = editField {
                textColor = BaseActivity.gold
                padding = PARAM_LAYOUT * 5
                hintTextColor = BaseActivity.gold
            }.lparams(width = 800) {
                alignParentLeft()
                topMargin = 20
                leftMargin = 50
            }

            var img = imageButton() {
                scaleType = ImageView.ScaleType.FIT_CENTER
                backgroundColor = Color.TRANSPARENT
                onClick {
                    if(kind == 0) {
                        UserModel.currentUser!!.needs.add(edit.text.toString())
                    } else {
                        UserModel.currentUser!!.dreams.add(edit.text.toString())
                    }
                    adpt.addItem(Link(edit.text.toString(), Runnable{}))
                    edit.setText("")
                }
            }.lparams(width = 150) {
                alignParentRight()
                rightMargin = 60
            }
            img.setImageResource(R.mipmap.ic_add_to_list)
        }
        list = recyclerView {
            adapter = adpt
            layoutManager = LinearLayoutManager(ctx)
        }
    }
}

inline fun ViewManager.tagList(theme: Int = 0) = tagList(theme) {}
inline fun ViewManager.tagList(theme: Int = 0, init: TagList.() -> Unit) =
        ankoView(::TagList, theme, init)
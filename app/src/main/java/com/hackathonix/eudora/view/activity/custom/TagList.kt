package com.hackathonix.eudora.view.activity.custom

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.hackathonix.eudora.util.PARAM_LAYOUT
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by daniel on 8/11/17.
 */
class TagList(ctx: Context) : LinearLayout(ctx) {

    lateinit var text : TextView
    var list : RecyclerView

    init {
        orientation = LinearLayout.VERTICAL
        relativeLayout {
            text = textView {
                padding = PARAM_LAYOUT * 2
            }.lparams {
                alignParentLeft()
            }
            button("+") {

            }.lparams {
                alignParentRight()
            }
        }
        list = recyclerView {

        }
    }
}

inline fun ViewManager.tagList(theme: Int = 0) = tagList(theme) {}
inline fun ViewManager.tagList(theme: Int = 0, init: TagList.() -> Unit) =
        ankoView(::TagList, theme, init)
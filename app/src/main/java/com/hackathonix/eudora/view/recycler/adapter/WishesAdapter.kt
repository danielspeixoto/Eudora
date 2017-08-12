package com.hackathonix.eudora.view.recycler.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hackathonix.eudora.model.Link
import com.hackathonix.eudora.model.UserModel
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.BaseActivity
import com.hackathonix.eudora.view.activity.GoalsActivity
import org.jetbrains.anko.*

/**
 * Created by daniel on 8/12/17.
 */
class WishesAdapter(activity: Context) :
        LinksAdapter(activity) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return WishesAdapter.ItemUI().createHolder(
                AnkoContext.create(parent!!.context,
                        parent))
    }

    class ItemUI : AnkoComponent<ViewGroup> {

        lateinit var nameText: TextView

        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout {
                    lparams(width = matchParent)
                    nameText = textView {
                        textColor = BaseActivity.purple
                        textSize = (PARAM_LAYOUT * 2).toFloat()
                    }.lparams(width = matchParent) {
                        margin = dip(PARAM_LAYOUT * 2)
                    }
//                    view {
//                        backgroundColor = Color.GRAY
//                    }.lparams(width = matchParent, height = 1)
                }
            }
        }

        fun createHolder(ui: AnkoContext<ViewGroup>): DrawerHolder {
            val holder = DrawerHolder(createView(ui))
            holder.nameText = nameText
            return holder
        }

    }


}

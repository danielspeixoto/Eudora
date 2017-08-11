package com.hackathonix.eudora.view.recycler.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hackathonix.eudora.model.Link
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.BaseActivity
import com.hackathonix.eudora.view.recycler.holder.BaseHolder
import org.jetbrains.anko.*

/**
 * Created by daniel on 8/11/17.
 */
open class LinksAdapter(activity: BaseActivity) :
        BaseAdapter<Link>(activity) {

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): RecyclerView.ViewHolder {
        return LinksAdapter.ItemUI().createHolder(
                AnkoContext.create(parent!!.context,
                        parent))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        holder as LinksAdapter.DrawerHolder
        holder.item = data[position]
        holder.adapter = this
        holder.onPostCreated()

    }

    class ItemUI : AnkoComponent<ViewGroup> {

        lateinit var nameText: TextView

        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout {
                    lparams(width = matchParent)
                    nameText = textView {
                        textSize = (PARAM_LAYOUT * 3).toFloat()
                    }.lparams(width = matchParent) {
                        margin = dip(PARAM_LAYOUT * 2)
                    }
                    view {
                        backgroundColor = Color.GRAY
                    }.lparams(width = matchParent, height = 1)
                }
            }
        }

        fun createHolder(ui: AnkoContext<ViewGroup>): DrawerHolder {
            val holder = DrawerHolder(createView(ui))
            holder.nameText = nameText
            return holder
        }

    }

    class DrawerHolder(itemView: View) : BaseHolder<Link>(itemView) {

        lateinit var nameText: TextView

        override fun onPostCreated() {
            nameText.text = item!!.name
            itemView.onClick {
                item!!.direction.run()
            }

        }
    }
}

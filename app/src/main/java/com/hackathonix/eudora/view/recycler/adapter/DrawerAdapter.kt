package com.hackathonix.eudora.view.recycler.adapter

import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.hackathonix.eudora.R
import com.hackathonix.eudora.model.Link
import com.hackathonix.eudora.model.UserModel
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.BaseActivity
import com.hackathonix.eudora.view.activity.GoalsActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import java.security.Permissions
import android.support.v4.content.ContextCompat.startActivity

/**
 * Created by daniel on 8/11/17.
 */
class DrawerAdapter(activity: BaseActivity) :
        LinksAdapter(activity) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            0 -> return InfoUI().createHolder(AnkoContext.create(parent!!.context,
                    parent))

            2 -> return ShareUI().createHolder(AnkoContext.create(parent!!.context,
                    parent))
            else -> return LinksAdapter.ItemUI().createHolder(
                    AnkoContext.create(parent!!.context,
                            parent))
        }
    }

    class InfoUI : AnkoComponent<ViewGroup> {

        lateinit var nameText: TextView
        lateinit var cardView: CardView

        //TODO
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent)
                    cardView = cardView {
                        linearLayout {
                            lparams(width = matchParent) {
                                padding = dip(PARAM_LAYOUT * 2)
                            }
                            orientation = LinearLayout.HORIZONTAL
                            nameText = textView {
                                textSize = 26f
                            }
                        }
                    }.lparams(width = matchParent) {
                        margin = dip(PARAM_LAYOUT / 2)
                    }
                }
            }
        }

        fun createHolder(ui: AnkoContext<ViewGroup>): ProductAdapter.ProductHolder {
            val holder = ProductAdapter.ProductHolder(createView(ui))
            //holder.nameText = nameText
            holder.cardView = cardView
            return holder
        }

    }

    class ShareUI : AnkoComponent<ViewGroup> {

        lateinit var nameText: TextView
        lateinit var cardView: CardView

        //TODO
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent)
                    cardView = cardView {
                        linearLayout {
                            lparams(width = matchParent) {
                                padding = dip(PARAM_LAYOUT * 2)
                            }
                            orientation = LinearLayout.HORIZONTAL
                            nameText = textView {
                                textSize = 26f
                            }
                        }
                    }.lparams(width = matchParent) {
                        margin = dip(PARAM_LAYOUT / 2)
                    }
                }
            }
        }

        fun createHolder(ui: AnkoContext<ViewGroup>): ProductAdapter.ProductHolder {
            val holder = ProductAdapter.ProductHolder(createView(ui))
//            holder.nameText = nameText
            holder.cardView = cardView
            return holder
        }

    }

    override fun getItemCount() : Int {
        return data.size + 2
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0) return 0
        if(position == data.size + 1) return 2
        return 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position > 0 && position < data.size) {
            super.onBindViewHolder(holder, position)
        }

    }

    init {
        addItem(
                Link("Financeiro",
                        Runnable {

                        })
        )
        addItem(
                Link("Meta Pessoal",
                        Runnable {
                            activity.startActivity<GoalsActivity>()
                        })
        )
        addItem(
                Link("Benefícios",
                        Runnable {

                        })
        )
        addItem(
                Link("Ajuda",
                        Runnable {

                        })
        )

    }
}

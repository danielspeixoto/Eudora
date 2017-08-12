package com.hackathonix.eudora.view.recycler.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hackathonix.eudora.model.Client
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.BaseActivity
import com.hackathonix.eudora.view.recycler.holder.BaseHolder
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by daniel on 8/12/17.
 */
class ClientAdapter(activity: Context) :
        BaseAdapter<Client>(activity) {

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): RecyclerView.ViewHolder {

        return ItemUI().createHolder(AnkoContext.create(parent!!.context,
                parent))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {

        holder as ClientHolder
        holder.item = data[position]
        holder.adapter = this
        holder.onPostCreated()

    }

    class ItemUI : AnkoComponent<ViewGroup> {

        // lateinit var nameText: TextView
        lateinit var cardView: CardView
//        lateinit var image: ImageView
        lateinit var text: TextView

        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent)
                    cardView = cardView {
//                        linearLayout {
//                            image = imageView()
//                            text = textView() {
//                                textSize = (PARAM_LAYOUT * 2).toFloat()
//                            }.lparams {
//                                leftPadding = 70
//                            }
//                        }

                        linearLayout() {
//                            image = imageView().lparams(width = 80) {
//                                id = 9023
//                                alignParentLeft()
//                            }
                            padding = 50
                            text = textView() {
                                id = 234292
                                textSize = (PARAM_LAYOUT * 2).toFloat()
                            }.lparams {
                                leftPadding = 70
                            }
                        }
                    }.lparams(width = matchParent) {
                        margin = dip(PARAM_LAYOUT / 2)
                    }
                }
            }
        }

        fun createHolder(ui: AnkoContext<ViewGroup>): ClientHolder {
            val holder = ClientHolder(createView(ui))
//            holder.nameText = nameText
            holder.cardView = cardView
//            holder.image = image
            holder.text = text
            return holder
        }

    }

    class ClientHolder(itemView: View) : BaseHolder<Client>(itemView) {

        //    lateinit var nameText: TextView
        lateinit var cardView: CardView
//        lateinit var image: ImageView
        lateinit var text: TextView

        override fun onPostCreated() {
            //     nameText.text = item!!.name
            text.text = item!!.name
//            image.setImageResource(item!!.picture)
        }
    }

}
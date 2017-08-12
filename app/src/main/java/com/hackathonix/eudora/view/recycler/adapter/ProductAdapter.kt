package com.hackathonix.eudora.view.recycler.adapter

import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.hackathonix.eudora.model.Product
import com.hackathonix.eudora.util.PARAM_LAYOUT
import com.hackathonix.eudora.view.activity.BaseActivity
import com.hackathonix.eudora.view.activity.InfoProductActivity
import com.hackathonix.eudora.view.recycler.holder.BaseHolder
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by daniel on 8/11/17.
 */
class ProductAdapter(activity: BaseActivity) :
        BaseAdapter<Product>(activity) {

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): RecyclerView.ViewHolder {

        return ItemUI().createHolder(AnkoContext.create(parent!!.context,
                parent))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {

        holder as ProductHolder
        holder.item = data[position]
        holder.adapter = this
        holder.onPostCreated()

    }

    class ItemUI : AnkoComponent<ViewGroup> {

       // lateinit var nameText: TextView
        lateinit var cardView: CardView
        lateinit var image: ImageView

        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    lparams(width = matchParent)
                    cardView = cardView {
                        linearLayout {
                            image = imageView()
                        }
                    }.lparams(width = matchParent, height = 540) {
                        margin = dip(PARAM_LAYOUT / 2)
                    }
                }
            }
        }

        fun createHolder(ui: AnkoContext<ViewGroup>): ProductHolder {
            val holder = ProductHolder(createView(ui))
//            holder.nameText = nameText
            holder.cardView = cardView
            holder.image = image
            return holder
        }

    }

    class ProductHolder(itemView: View) : BaseHolder<Product>(itemView) {

    //    lateinit var nameText: TextView
        lateinit var cardView: CardView
        lateinit var image: ImageView

        override fun onPostCreated() {
       //     nameText.text = item!!.name
            image.setImageResource(item!!.image)

            itemView.onClick {
                val intent = Intent(adapter.activity,
                        InfoProductActivity::class.java)

                intent.putExtra("product",
                        item)
                adapter.activity.startActivity(intent)
            }
        }
    }

}


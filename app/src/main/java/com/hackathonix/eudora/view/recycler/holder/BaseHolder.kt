package com.hackathonix.eudora.view.recycler.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.hackathonix.eudora.view.recycler.adapter.BaseAdapter

/**
 * Created by daniel on 8/10/17.
 */
abstract class BaseHolder<O>(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    var item: O? = null
    lateinit var adapter : BaseAdapter<O>

    abstract fun onPostCreated()

}
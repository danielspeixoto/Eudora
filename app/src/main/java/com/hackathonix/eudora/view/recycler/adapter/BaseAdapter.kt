package com.hackathonix.eudora.view.recycler.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.hackathonix.eudora.view.activity.BaseActivity

/**
 * Created by daniel on 8/10/17.
 */
abstract class BaseAdapter<O> (var activity : Context) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data : ArrayList<O> = ArrayList()

    open fun addItem(t: O) {
        data.add(t)
        notifyDataSetChanged()
    }

    fun getItem(position : Int) = data.get(position)

    fun removeItem(position : Int) {
        data.removeAt(position)
        notifyDataSetChanged()
    }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    fun getIterator(): Iterator<O> {
        return data.iterator()
    }

    override fun getItemCount() : Int {
        return data.size
    }

}
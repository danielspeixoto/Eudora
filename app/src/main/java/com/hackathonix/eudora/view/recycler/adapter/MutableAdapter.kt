package com.hackathonix.eudora.view.recycler.adapter

import com.hackathonix.eudora.view.activity.BaseActivity

/**
 * Created by daniel on 8/11/17.
 */
abstract class MutableAdapter<O>(activity : BaseActivity) : BaseAdapter<O>(activity) {

    companion object {
        val LOADED = "loaded"
        val IDLE = "idle"
        val LOADING = "loading"
        val RELOADING = "reloading"
        val ERROR = "error"
    }
    var status = LOADING
        set(update) {
            field = update
            notifyDataSetChanged()
        }

    val EMPTY_VIEW = 0
    val ITEM_VIEW = 1
    val LOADING_VIEW = 2

    override fun getItemCount() : Int {
        if(status == MutableAdapter.LOADING || status == MutableAdapter.ERROR )
            return data.size + 1
        if(status == MutableAdapter.LOADED && data.size == 0)
            return 1
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        if(position == data.size) {
            if(status == MutableAdapter.LOADING) {
                return LOADING_VIEW
            } else if(status == MutableAdapter.ERROR || status == MutableAdapter.LOADED) {
                return EMPTY_VIEW
            }
        }
        return ITEM_VIEW
    }
}
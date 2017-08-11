package com.hackathonix.eudora

import android.support.v4.widget.SwipeRefreshLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by daniel on 8/11/17.
 */
//class HomePresenter(private val view: Home.View) : Home.Presenter {
//
//    override var refreshLayout: SwipeRefreshLayout? = null
//    override var adapter: VisitorAdapter? = null
//
//    override fun syncItems() {
//        if(adapter != null) {
//            adapter!!.clearData()
//            VisitorModel.getNonConnected()
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe { list, throwable ->
//                        if (throwable != null) {
//                            adapter!!.status = MutableAdapter.ERROR
//                        } else {
//                            list.forEach { adapter!!.addItem(it) }
//                            adapter!!.status = MutableAdapter.LOADED
//                        }
//                        refreshLayout!!.isRefreshing = false
//                    }
//        }
//    }
//}
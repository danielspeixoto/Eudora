package com.hackathonix.eudora.view.activity

import android.app.ProgressDialog
import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.*
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import com.hackathonix.eudora.R
import com.hackathonix.eudora.model.ProductModel
import com.hackathonix.eudora.util.EMPTY_STRING
import com.hackathonix.eudora.view.recycler.adapter.DrawerAdapter
import com.hackathonix.eudora.view.recycler.adapter.ProductAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.drawerLayout
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * Created by daniel on 8/11/17.
 */
class HomeActivity : BaseActivity()  {

    lateinit var list: RecyclerView
    lateinit var refreshLayout : SwipeRefreshLayout
    lateinit var drawer: RecyclerView
    private var visitorAdapter = ProductAdapter(this)
    private var drawerAdapter = DrawerAdapter(this)
    lateinit var drawerLayout: DrawerLayout
    lateinit var drawerToggle : ActionBarDrawerToggle

    lateinit var toolbar : Toolbar

    lateinit var progressDialog: ProgressDialog
    var isLoading = true
        set(value) {
            field = value
            progressDialog.dismiss()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drawerLayout = drawerLayout {
            lparams(width = matchParent, height = matchParent)
            verticalLayout {
                appBarLayout(R.style.AppTheme_AppBarOverlay) {
                    fitsSystemWindows = true
                    toolbar = toolbar(R.style.AppTheme_PopupOverlay) {
                        setTitleTextColor(Color.WHITE)
                    }.lparams(width = matchParent, height = matchParent)
                }.lparams(width = matchParent)
                setSupportActionBar(toolbar)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                coordinatorLayout {
                    refreshLayout = swipeRefreshLayout {
                        list = recyclerView {
                            layoutManager = GridLayoutManager(this@HomeActivity, 2)
                            adapter = visitorAdapter
                            ProductModel().products.forEach {
                                visitorAdapter.addItem(it)
                            }
                        }.lparams(width = matchParent, height = matchParent)
                    }.lparams(width = matchParent, height = matchParent)
                }.lparams(width = matchParent, height = matchParent)
            }.lparams(width = matchParent, height = matchParent)
            drawer = recyclerView {
                layoutManager = LinearLayoutManager(this@HomeActivity)
                adapter = drawerAdapter
                backgroundColor = Color.WHITE
            }.lparams(width = matchParent, height = matchParent) {
                gravity = Gravity.START
            }
        }
        drawerToggle = ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.accept,
                R.string.decline)
        drawerLayout.addDrawerListener(drawerToggle)
    }

//    lateinit var searchView : SearchView

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_home, menu)
//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        searchView = menu.findItem(R.id.search_view).actionView as SearchView
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(ComponentName(this, SearchResultsActivity::class.java)))
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchView.setQuery(EMPTY_STRING, false)
//                searchView.isIconified = true
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//
//        })
//        return true
//    }

    override fun onBackPressed() {
        super.onBackPressed();
//        if (!searchView.isIconified()) {
//            searchView.setIconified(true);
//        } else {
//            super.onBackPressed();
//        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }

}
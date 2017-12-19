package com.example.denis.databaseroom.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.ui.base.BaseActivity
import com.example.denis.databaseroom.ui.gallery.GalleryActivity
import com.example.denis.databaseroom.ui.main.pack.PackageFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

/**
 * Created by denis on 13/12/2017.
 */
class MainActivity: BaseActivity(), MainMvpView, NavigationView.OnNavigationItemSelectedListener {


    companion object {
        fun getStartInject(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    @Inject lateinit var presenter: MainMvpPresenter<MainMvpView>

    lateinit var drawerToggle: ActionBarDrawerToggle




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.inject(this)

        presenter.onAttach(this)

        setUp()
    }

    override fun setUp() {
        setSupportActionBar(toolbar)
        setToolbarTitle("Packages")
        setTaskFragment(PackageFragment.newInstance())

        drawerToggle = ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        )

        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home -> drawer.closeDrawers()
            R.id.gallery -> openGalleryActivity()
        }
        return false
    }

    override fun openGalleryActivity() {
        startActivity(GalleryActivity.getStartInject(applicationContext))
    }

    override fun setTaskFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }


    fun setToolbarTitle(title: String) {
        toolbarTitle.text = title
    }





}
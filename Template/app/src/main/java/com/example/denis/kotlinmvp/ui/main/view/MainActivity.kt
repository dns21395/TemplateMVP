package com.example.denis.kotlinmvp.ui.main.view

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.PermissionManager
import com.example.denis.kotlinmvp.ui.base.view.BaseActivity
import com.example.denis.kotlinmvp.ui.main.fragments.application.view.ApplicationFragment
import com.example.denis.kotlinmvp.ui.main.fragments.people.view.PeopleFragment
import com.example.denis.kotlinmvp.ui.main.interactor.MainMVPInteractor
import com.example.denis.kotlinmvp.ui.main.presenter.MainMVPPresenter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

/**
 * Created by denis on 28/01/2018.
 */
class MainActivity : BaseActivity(), MainMVPView, HasSupportFragmentInjector, NavigationView.OnNavigationItemSelectedListener {

    private val TAG = "MainActivity"

    @Inject internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>
    @Inject internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        updateFrameLayout(ApplicationFragment.newInstance())
        setUp()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun updateFrameLayout(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}

    private fun setUp() {
        setSupportActionBar(toolbar)

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
            R.id.applications -> {
                updateFrameLayout(ApplicationFragment.newInstance())
                updateTitle(R.string.applications)
            }
            R.id.gallery -> {
                presenter.onDrawerOptionGallery()
                updateTitle(R.string.gallery)
            }
            R.id.people -> {
                updateFrameLayout(PeopleFragment.newInstance())
                updateTitle(R.string.people)
            }
        }
        drawer.closeDrawers()
        return false
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PermissionManager.REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) presenter.onDrawerOptionGallery()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PermissionManager.REQUEST_CODE) presenter.onDrawerOptionGallery()
    }

    override fun updateTitle(stringId: Int) {
        toolbarTitle.text = getString(stringId)
    }


}
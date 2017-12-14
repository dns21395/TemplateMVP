package com.example.denis.databaseroom.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.ui.base.BaseActivity
import com.example.denis.databaseroom.ui.main.pack.PackageFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

/**
 * Created by denis on 13/12/2017.
 */
class MainActivity: BaseActivity(), MainMvpView {

    companion object {
        fun getStartInject(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    @Inject lateinit var presenter: MainMvpPresenter<MainMvpView>


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
    }

    override fun setTaskFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }


    fun setToolbarTitle(title: String) {
        toolbarTitle.text = title
    }





}
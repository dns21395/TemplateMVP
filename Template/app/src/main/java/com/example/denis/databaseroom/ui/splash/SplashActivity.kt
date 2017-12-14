package com.example.denis.databaseroom.ui.splash

import android.os.Bundle
import com.example.denis.databaseroom.ui.base.BaseActivity
import com.example.denis.databaseroom.ui.main.MainActivity
import javax.inject.Inject

/**
 * Created by denis on 13/12/2017.
 */
class SplashActivity : BaseActivity(), SplashMvpView {

    @Inject lateinit var presenter: SplashMvpPresenter<SplashMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)

        presenter.onAttach(this)

        setUp()
    }

    override fun openMainActivity() {
        startActivity(MainActivity.getStartInject(this))
        finish()
    }

    override fun setUp() {
        transparentStatusBar()
    }
}
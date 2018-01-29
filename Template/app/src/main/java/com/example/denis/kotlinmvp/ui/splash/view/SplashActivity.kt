package com.example.denis.kotlinmvp.ui.splash.view

import android.content.Intent
import android.os.Bundle
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.ui.base.view.BaseActivity
import com.example.denis.kotlinmvp.ui.main.view.MainActivity
import com.example.denis.kotlinmvp.ui.splash.interactor.SplashMVPInteractor
import com.example.denis.kotlinmvp.ui.splash.presenter.SplashMVPPresenter
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

/**
 * Created by denis on 27/01/2018.
 */
class SplashActivity : BaseActivity(), SplashMVPView {

    @Inject lateinit var presenter: SplashMVPPresenter<SplashMVPView, SplashMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
        transparentStatusBar()
        setOnClickListeners()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}

    private fun setOnClickListeners() {
        btnOpenMainActivity.setOnClickListener {
            openMainActivity()
        }
    }
}
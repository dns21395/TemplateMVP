package com.example.denis.databaseroom.ui.base

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.denis.databaseroom.di.component.ActivityComponent
import com.example.denis.databaseroom.di.component.DaggerActivityComponent
import com.example.denis.databaseroom.di.module.ActivityModule
import com.example.denis.databaseroom.utils.app
import com.readystatesoftware.systembartint.SystemBarTintManager

/**
 * Created by denis on 13/12/2017.
 */
abstract class BaseActivity: AppCompatActivity(), MvpView {
    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(app.applicationComponent)
                .build()
    }

    protected abstract fun setUp()

    fun transparentStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT

        val tintManager = SystemBarTintManager(this)
        // enable status bar tint
        tintManager.isStatusBarTintEnabled = true
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true)
    }
}
package com.example.denis.kotlinmvp.ui.base.view


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.readystatesoftware.systembartint.SystemBarTintManager
import dagger.android.AndroidInjection

/**
 * Created by denis on 27/01/2018.
 */
abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }


    private fun performDI() = AndroidInjection.inject(this)


    fun transparentStatusBar() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT

            val tintManager = SystemBarTintManager(this)
            // enable status bar tint
            tintManager.isStatusBarTintEnabled = true
            // enable navigation bar tint
            tintManager.setNavigationBarTintEnabled(true)
        }
    }

}
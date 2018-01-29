package com.example.denis.kotlinmvp.ui.main.view

import android.support.v4.app.Fragment
import com.example.denis.kotlinmvp.ui.base.view.MVPView

/**
 * Created by denis on 28/01/2018.
 */
interface MainMVPView : MVPView {
    fun updateFrameLayout(fragment: Fragment)
}
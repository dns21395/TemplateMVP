package com.example.denis.databaseroom.ui.main

import android.support.v4.app.Fragment
import com.example.denis.databaseroom.ui.base.MvpView

/**
 * Created by denis on 13/12/2017.
 */
interface MainMvpView: MvpView {
    fun setTaskFragment(fragment: Fragment)
}
package com.example.denis.databaseroom.ui.gallery.empty

import com.example.denis.databaseroom.ui.base.MvpView

/**
 * Created by denis on 19/12/2017.
 */
interface EmptyMvpView : MvpView {
    fun requestPermission()

    fun openSettings()
}
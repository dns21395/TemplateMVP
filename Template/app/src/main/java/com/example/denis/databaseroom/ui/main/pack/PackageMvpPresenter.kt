package com.example.denis.databaseroom.ui.main.pack

import com.example.denis.databaseroom.ui.base.MvpPresenter

/**
 * Created by denis on 14/12/2017.
 */
interface PackageMvpPresenter<V: PackageMvpView>: MvpPresenter<V> {
    fun getPackages()
}
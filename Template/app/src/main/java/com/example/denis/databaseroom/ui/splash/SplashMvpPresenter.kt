package com.example.denis.databaseroom.ui.splash

import android.content.Context
import com.example.denis.databaseroom.di.PerActivity
import com.example.denis.databaseroom.ui.base.MvpPresenter

/**
 * Created by denis on 13/12/2017.
 */
@PerActivity
interface SplashMvpPresenter<V: SplashMvpView> : MvpPresenter<V> {
    fun insertPackagesToDatabase()
}
package com.example.denis.databaseroom.ui.main

import com.example.denis.databaseroom.di.PerActivity
import com.example.denis.databaseroom.ui.base.MvpPresenter

/**
 * Created by denis on 13/12/2017.
 */
@PerActivity
interface MainMvpPresenter<V: MainMvpView> : MvpPresenter<V> {
}
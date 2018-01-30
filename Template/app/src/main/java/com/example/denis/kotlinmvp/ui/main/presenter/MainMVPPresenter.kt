package com.example.denis.kotlinmvp.ui.main.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.interactor.MainMVPInteractor
import com.example.denis.kotlinmvp.ui.main.view.MainMVPView

/**
 * Created by denis on 28/01/2018.
 */
interface MainMVPPresenter<V: MainMVPView, I: MainMVPInteractor> : MVPPresenter<V, I> {
    fun onDrawerOptionGallery()
}
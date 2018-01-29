package com.example.denis.kotlinmvp.ui.splash.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.splash.interactor.SplashMVPInteractor
import com.example.denis.kotlinmvp.ui.splash.view.SplashMVPView

/**
 * Created by denis on 27/01/2018.
 */
interface SplashMVPPresenter<V: SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<V, I> {

}
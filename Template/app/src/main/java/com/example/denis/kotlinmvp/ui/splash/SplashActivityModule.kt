package com.example.denis.kotlinmvp.ui.splash

import com.example.denis.kotlinmvp.ui.splash.interactor.SplashInteractor
import com.example.denis.kotlinmvp.ui.splash.interactor.SplashMVPInteractor
import com.example.denis.kotlinmvp.ui.splash.presenter.SplashMVPPresenter
import com.example.denis.kotlinmvp.ui.splash.presenter.SplashPresenter
import com.example.denis.kotlinmvp.ui.splash.view.SplashMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by denis on 26/01/2018.
 */
@Module
class SplashActivityModule {
    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashMVPInteractor = splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMVPView, SplashMVPInteractor>)
        : SplashMVPPresenter<SplashMVPView, SplashMVPInteractor> = splashPresenter
}
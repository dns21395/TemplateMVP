package com.example.denis.kotlinmvp.ui.main

import com.example.denis.kotlinmvp.ui.main.interactor.MainInteractor
import com.example.denis.kotlinmvp.ui.main.interactor.MainMVPInteractor
import com.example.denis.kotlinmvp.ui.main.presenter.MainMVPPresenter
import com.example.denis.kotlinmvp.ui.main.presenter.MainPresenter
import com.example.denis.kotlinmvp.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by denis on 28/01/2018.
 */
@Module
class MainActivityModule {
    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
        : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter
}
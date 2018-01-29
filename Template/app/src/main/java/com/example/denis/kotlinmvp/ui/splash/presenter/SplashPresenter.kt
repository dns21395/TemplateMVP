package com.example.denis.kotlinmvp.ui.splash.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.splash.interactor.SplashMVPInteractor
import com.example.denis.kotlinmvp.ui.splash.view.SplashMVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 27/01/2018.
 */
class SplashPresenter<V: SplashMVPView, I: SplashMVPInteractor>
    @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), SplashMVPPresenter<V, I> {
}
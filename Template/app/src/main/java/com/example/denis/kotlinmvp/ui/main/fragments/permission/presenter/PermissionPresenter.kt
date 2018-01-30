package com.example.denis.kotlinmvp.ui.main.fragments.permission.presenter

import android.app.Activity
import com.example.denis.kotlinmvp.ui.base.presenter.BasePresenter
import com.example.denis.kotlinmvp.ui.main.fragments.permission.interactor.PermissionMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.permission.view.PermissionMVPView
import com.example.denis.kotlinmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PermissionPresenter<V : PermissionMVPView, I : PermissionMVPInteractor>
    @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), PermissionMVPPResenter<V, I> {

    override fun requestPermission(activity: Activity) {
        interactor?.let {
            it.requestPermission(activity)
        }
    }

    override fun onGivePermissionClicked(activity: Activity) {
        interactor?.let {
            it.callOpenSettings(activity)
        }
    }


}
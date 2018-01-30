package com.example.denis.kotlinmvp.ui.main.fragments.permission.presenter

import android.app.Activity
import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.permission.interactor.PermissionMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.permission.view.PermissionMVPView

/**
 * Created by denis on 30/01/2018.
 */
interface PermissionMVPPResenter<V: PermissionMVPView, I : PermissionMVPInteractor> : MVPPresenter<V, I> {
    fun requestPermission(activity: Activity)
    fun onGivePermissionClicked(activity: Activity)
}
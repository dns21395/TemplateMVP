package com.example.denis.kotlinmvp.ui.main.fragments.permission.interactor

import android.app.Activity
import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor

/**
 * Created by denis on 30/01/2018.
 */
interface PermissionMVPInteractor : MVPInteractor {
    fun requestPermission(activity: Activity)
    fun callOpenSettings(activity: Activity)
}
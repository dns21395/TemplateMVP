package com.example.denis.kotlinmvp.ui.main.fragments.permission.interactor

import android.app.Activity
import com.example.denis.kotlinmvp.model.PermissionManager
import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PermissionInteractor @Inject internal constructor(private val permissionManager: PermissionManager, preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), PermissionMVPInteractor {
    override fun requestPermission(activity: Activity) {
        permissionManager.requestReadExternalStoragePermission(activity)
    }

    override fun callOpenSettings(activity: Activity) {
        permissionManager.openSettings(activity)
    }

}
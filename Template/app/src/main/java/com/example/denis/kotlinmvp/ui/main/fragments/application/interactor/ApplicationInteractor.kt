package com.example.denis.kotlinmvp.ui.main.fragments.application.interactor

import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject
import com.example.denis.kotlinmvp.model.ApplicationInfoManager
import com.example.denis.kotlinmvp.model.model.AppInfo


/**
 * Created by denis on 28/01/2018.
 */
class ApplicationInteractor
     @Inject internal constructor(private val applicationInfoManager: ApplicationInfoManager, preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), ApplicationMVPInteractor {

    override fun getApplicationInfoArray(): ArrayList<AppInfo> =
            applicationInfoManager.getApplicationInfoArray()

}
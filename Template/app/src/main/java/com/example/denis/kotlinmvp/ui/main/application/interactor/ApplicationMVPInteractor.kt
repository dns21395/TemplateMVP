package com.example.denis.kotlinmvp.ui.main.application.interactor

import com.example.denis.kotlinmvp.model.model.AppInfo
import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor

/**
 * Created by denis on 28/01/2018.
 */
interface ApplicationMVPInteractor : MVPInteractor {
    fun getApplicationInfoArray(): ArrayList<AppInfo>
}
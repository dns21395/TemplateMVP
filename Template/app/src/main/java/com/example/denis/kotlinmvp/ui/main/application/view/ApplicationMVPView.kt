package com.example.denis.kotlinmvp.ui.main.application.view

import com.example.denis.kotlinmvp.model.model.AppInfo
import com.example.denis.kotlinmvp.ui.base.view.MVPView

/**
 * Created by denis on 28/01/2018.
 */
interface ApplicationMVPView : MVPView {
    fun displayApplications(array: ArrayList<AppInfo>)
}
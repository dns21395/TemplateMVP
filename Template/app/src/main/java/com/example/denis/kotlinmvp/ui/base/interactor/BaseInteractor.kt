package com.example.denis.kotlinmvp.ui.base.interactor

import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper

/**
 * Created by denis on 27/01/2018.
 */
open class BaseInteractor() : MVPInteractor {
    protected lateinit var preferenceHelper: PreferenceHelper

    constructor(preferenceHelper: PreferenceHelper) : this() {
        this.preferenceHelper = preferenceHelper
    }


}
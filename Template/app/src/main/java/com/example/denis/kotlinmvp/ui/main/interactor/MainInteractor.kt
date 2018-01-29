package com.example.denis.kotlinmvp.ui.main.interactor

import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by denis on 28/01/2018.
 */
class MainInteractor
    @Inject internal constructor(preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), MainMVPInteractor {

}
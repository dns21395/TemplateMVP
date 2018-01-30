package com.example.denis.kotlinmvp.ui.main.fragments.people.interactor

import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PeopleInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), PeopleMVPInteractor {
}
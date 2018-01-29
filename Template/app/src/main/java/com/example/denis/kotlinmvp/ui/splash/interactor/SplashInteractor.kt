package com.example.denis.kotlinmvp.ui.splash.interactor

import android.content.Context
import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by denis on 27/01/2018.
 */
class SplashInteractor
    @Inject constructor(private val context: Context, preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), SplashMVPInteractor {
}
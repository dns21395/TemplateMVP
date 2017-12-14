package com.example.denis.databaseroom.di.component

import com.example.denis.databaseroom.di.PerActivity
import com.example.denis.databaseroom.di.module.ActivityModule
import com.example.denis.databaseroom.ui.main.MainActivity
import com.example.denis.databaseroom.ui.splash.SplashActivity
import dagger.Component

/**
 * Created by denis on 13/12/2017.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(splashActivity: SplashActivity)

    fun inject(mainActivity: MainActivity)
}
package com.example.denis.kotlinmvp.ui.main.fragments.application

import com.example.denis.kotlinmvp.ui.main.fragments.application.view.ApplicationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by denis on 28/01/2018.
 */
@Module
internal abstract class ApplicationFragmentProvider {

    @ContributesAndroidInjector(modules = [(ApplicationFragmentModule::class)])
    internal abstract fun provideApplicationFragment(): ApplicationFragment
}
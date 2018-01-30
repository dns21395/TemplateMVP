package com.example.denis.kotlinmvp.ui.main.fragments.people

import com.example.denis.kotlinmvp.ui.main.fragments.people.view.PeopleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by denis on 30/01/2018.
 */
@Module
internal abstract class PeopleFragmentProvider {
    @ContributesAndroidInjector(modules = [(PeopleFragmentModule::class)])
    internal abstract fun providePeopleFragment(): PeopleFragment
}
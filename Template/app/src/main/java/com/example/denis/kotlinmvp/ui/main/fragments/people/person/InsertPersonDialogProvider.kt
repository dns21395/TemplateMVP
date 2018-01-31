package com.example.denis.kotlinmvp.ui.main.fragments.people.person

import com.example.denis.kotlinmvp.ui.main.fragments.people.person.view.InsertPersonDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by denis on 31/01/2018.
 */
@Module
internal abstract class InsertPersonDialogProvider {
    @ContributesAndroidInjector(modules = [(InsertPersonDialogModule::class)])
    internal abstract fun provideInsertPersonDialog(): InsertPersonDialog
}
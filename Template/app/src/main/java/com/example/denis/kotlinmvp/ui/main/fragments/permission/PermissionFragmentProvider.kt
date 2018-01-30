package com.example.denis.kotlinmvp.ui.main.fragments.permission

import com.example.denis.kotlinmvp.ui.main.fragments.permission.view.PermissionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by denis on 30/01/2018.
 */
@Module
internal abstract class PermissionFragmentProvider {
    @ContributesAndroidInjector(modules = [(PermissionFragmentModule::class)])
    internal abstract fun provideEmptyFragment(): PermissionFragment
}
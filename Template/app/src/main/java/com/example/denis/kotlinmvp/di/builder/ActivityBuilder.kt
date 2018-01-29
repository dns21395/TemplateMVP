package com.example.denis.kotlinmvp.di.builder

import com.example.denis.kotlinmvp.ui.main.MainActivityModule
import com.example.denis.kotlinmvp.ui.main.application.ApplicationFragmentModule
import com.example.denis.kotlinmvp.ui.main.application.ApplicationFragmentProvider
import com.example.denis.kotlinmvp.ui.main.gallery.GalleryFragmentProvider
import com.example.denis.kotlinmvp.ui.main.view.MainActivity
import com.example.denis.kotlinmvp.ui.splash.SplashActivityModule
import com.example.denis.kotlinmvp.ui.splash.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by denis on 26/01/2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (ApplicationFragmentProvider::class), (GalleryFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity
}
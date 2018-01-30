package com.example.denis.kotlinmvp.ui.main.fragments.gallery

import com.example.denis.kotlinmvp.ui.main.fragments.gallery.view.GalleryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by denis on 29/01/2018.
 */
@Module
internal abstract class GalleryFragmentProvider {

    @ContributesAndroidInjector(modules = [(GalleryFragmentModule::class)])
    internal abstract fun provideGalleryFragment(): GalleryFragment
}
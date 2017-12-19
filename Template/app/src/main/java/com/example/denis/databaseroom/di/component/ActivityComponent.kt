package com.example.denis.databaseroom.di.component

import com.example.denis.databaseroom.di.PerActivity
import com.example.denis.databaseroom.di.module.ActivityModule
import com.example.denis.databaseroom.ui.gallery.GalleryActivity
import com.example.denis.databaseroom.ui.gallery.photos.PhotosFragment
import com.example.denis.databaseroom.ui.main.MainActivity
import com.example.denis.databaseroom.ui.main.pack.PackageFragment
import com.example.denis.databaseroom.ui.splash.SplashActivity
import dagger.Component

/**
 * Created by denis on 13/12/2017.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    // Activities

    fun inject(splashActivity: SplashActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(galleryActivity: GalleryActivity)

    // Fragments

    fun inject(packageFragment: PackageFragment)

    fun inject(photosFragment: PhotosFragment)

}
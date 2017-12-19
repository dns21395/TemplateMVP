package com.example.denis.databaseroom.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.denis.databaseroom.di.ActivityContext
import com.example.denis.databaseroom.di.PerActivity
import com.example.denis.databaseroom.ui.gallery.GalleryMvpPresenter
import com.example.denis.databaseroom.ui.gallery.GalleryMvpView
import com.example.denis.databaseroom.ui.gallery.GalleryPresenter
import com.example.denis.databaseroom.ui.gallery.empty.EmptyMvpPresenter
import com.example.denis.databaseroom.ui.gallery.empty.EmptyMvpView
import com.example.denis.databaseroom.ui.gallery.empty.EmptyPresenter
import com.example.denis.databaseroom.ui.gallery.photos.PhotosMvpPresenter
import com.example.denis.databaseroom.ui.gallery.photos.PhotosMvpView
import com.example.denis.databaseroom.ui.gallery.photos.PhotosPresenter
import com.example.denis.databaseroom.ui.main.MainMvpPresenter
import com.example.denis.databaseroom.ui.main.MainMvpView
import com.example.denis.databaseroom.ui.main.MainPresenter
import com.example.denis.databaseroom.ui.main.pack.PackageAdapter
import com.example.denis.databaseroom.ui.main.pack.PackageMvpPresenter
import com.example.denis.databaseroom.ui.main.pack.PackageMvpView
import com.example.denis.databaseroom.ui.main.pack.PackagePresenter
import com.example.denis.databaseroom.ui.splash.SplashMvpPresenter
import com.example.denis.databaseroom.ui.splash.SplashMvpView
import com.example.denis.databaseroom.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by denis on 13/12/2017.
 */
@Module
class ActivityModule(val activity: AppCompatActivity) {
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    // Activities

    @Provides
    @PerActivity
    fun provideSplashPresenter(presenter: SplashPresenter<SplashMvpView>): SplashMvpPresenter<SplashMvpView> = presenter

    @Provides
    @PerActivity
    fun provideMainPresenter(presenter: MainPresenter<MainMvpView>): MainMvpPresenter<MainMvpView> = presenter

    @Provides
    @PerActivity
    fun provideGalleryPresenter(presenter: GalleryPresenter<GalleryMvpView>): GalleryMvpPresenter<GalleryMvpView> = presenter

    // Fragments

    @Provides
    fun providePackagePresenter(presenter: PackagePresenter<PackageMvpView>): PackageMvpPresenter<PackageMvpView> = presenter

    @Provides
    fun providePhotosPresenter(presenter: PhotosPresenter<PhotosMvpView>): PhotosMvpPresenter<PhotosMvpView> = presenter

    @Provides
    fun provideEmptyPresenter(presenter: EmptyPresenter<EmptyMvpView>): EmptyMvpPresenter<EmptyMvpView> = presenter

    // Adapters

    @Provides
    fun providePackageAdapter(): PackageAdapter = PackageAdapter(provideContext())

    // Helpers

    @Provides
    fun provideLinearLayoutManager(activity: AppCompatActivity) = LinearLayoutManager(activity)

}
package com.example.denis.databaseroom.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.denis.databaseroom.di.ActivityContext
import com.example.denis.databaseroom.di.PerActivity
import com.example.denis.databaseroom.di.PreferenceInfo
import com.example.denis.databaseroom.ui.main.MainMvpPresenter
import com.example.denis.databaseroom.ui.main.MainMvpView
import com.example.denis.databaseroom.ui.main.MainPresenter
import com.example.denis.databaseroom.ui.splash.SplashMvpPresenter
import com.example.denis.databaseroom.ui.splash.SplashMvpView
import com.example.denis.databaseroom.ui.splash.SplashPresenter
import com.example.denis.databaseroom.utils.PREF_NAME
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

}
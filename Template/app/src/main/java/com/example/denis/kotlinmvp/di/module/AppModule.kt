package com.example.denis.kotlinmvp.di.module

import android.app.Application
import android.content.Context
import com.example.denis.kotlinmvp.model.preferences.AppPreferenceHelper
import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.di.PreferenceInfo
import com.example.denis.kotlinmvp.util.AppConstants
import com.example.denis.kotlinmvp.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by denis on 26/01/2018.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @PreferenceInfo
    internal fun providePreFileName(): String = AppConstants.PREF_NAME

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    @Singleton
    internal fun providePreHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper
}
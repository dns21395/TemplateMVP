package com.example.denis.databaseroom.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.denis.databaseroom.data.AppDataManager
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.data.db.AppDatabase
import com.example.denis.databaseroom.data.prefs.AppPreferencesHelper
import com.example.denis.databaseroom.data.prefs.PreferencesHelper
import com.example.denis.databaseroom.di.ApplicationContext
import com.example.denis.databaseroom.di.PreferenceInfo
import com.example.denis.databaseroom.utils.PREF_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by denis on 13/12/2017.
 */
@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper = appPreferencesHelper

    @Provides
    fun provideAppDatabase(): AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "we-need.db").build()


    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String = PREF_NAME
}
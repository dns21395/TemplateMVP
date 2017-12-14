package com.example.denis.databaseroom.di.component

import android.app.Application
import android.content.Context
import com.example.denis.databaseroom.App
import com.example.denis.databaseroom.data.DataManager
import com.example.denis.databaseroom.data.db.AppDatabase
import com.example.denis.databaseroom.di.ApplicationContext
import com.example.denis.databaseroom.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by denis on 13/12/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(app: App)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun appDatabase(): AppDatabase
}
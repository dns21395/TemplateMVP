package com.example.denis.databaseroom

import android.app.Application
import com.example.denis.databaseroom.di.component.ApplicationComponent
import com.example.denis.databaseroom.di.component.DaggerApplicationComponent
import com.example.denis.databaseroom.di.module.ApplicationModule

/**
 * Created by denis on 13/12/2017.
 */
class App : Application() {
     val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent.inject(this)
    }
}
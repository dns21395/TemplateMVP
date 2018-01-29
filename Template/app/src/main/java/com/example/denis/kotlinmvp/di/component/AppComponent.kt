package com.example.denis.kotlinmvp.di.component

import android.app.Application
import com.example.denis.kotlinmvp.App
import com.example.denis.kotlinmvp.di.builder.ActivityBuilder
import com.example.denis.kotlinmvp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by denis on 26/01/2018.
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}
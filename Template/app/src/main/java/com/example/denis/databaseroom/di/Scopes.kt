package com.example.denis.databaseroom.di

import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Created by denis on 13/12/2017.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PreferenceInfo

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerService

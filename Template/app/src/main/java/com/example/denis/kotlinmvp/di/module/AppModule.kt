package com.example.denis.kotlinmvp.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.denis.kotlinmvp.model.preferences.AppPreferenceHelper
import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.di.PreferenceInfo
import com.example.denis.kotlinmvp.model.database.AppDatabase
import com.example.denis.kotlinmvp.model.database.repository.age.AgeRepo
import com.example.denis.kotlinmvp.model.database.repository.age.AgeRepository
import com.example.denis.kotlinmvp.model.database.repository.name.NameRepo
import com.example.denis.kotlinmvp.model.database.repository.name.NameRepository
import com.example.denis.kotlinmvp.model.database.repository.person.PersonRepo
import com.example.denis.kotlinmvp.model.database.repository.person.PersonRepository
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
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @Singleton
    internal fun provideAgeRepo(appDatabase: AppDatabase): AgeRepo = AgeRepository(appDatabase.ageDao())

    @Provides
    @Singleton
    internal fun provideNameRepo(appDatabase: AppDatabase): NameRepo = NameRepository(appDatabase.nameDao())

    @Provides
    @Singleton
    internal fun providePersonRepo(appDatabase: AppDatabase): PersonRepo = PersonRepository(appDatabase.personDao(), appDatabase.nameDao(), appDatabase.ageDao())

    @Provides
    @Singleton
    internal fun providePreferenceHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper
}
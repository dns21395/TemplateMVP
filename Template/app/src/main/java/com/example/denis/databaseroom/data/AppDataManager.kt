package com.example.denis.databaseroom.data

import android.content.Context
import com.example.denis.databaseroom.data.db.AppDatabase
import com.example.denis.databaseroom.data.db.model.MyDatabase
import com.example.denis.databaseroom.data.prefs.PreferencesHelper
import com.example.denis.databaseroom.di.ApplicationContext
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by denis on 13/12/2017.
 */
@Singleton
class AppDataManager
    @Inject constructor(@ApplicationContext val context: Context,
                        private val database: AppDatabase,
                        private val preferencesHelper: PreferencesHelper)
    : DataManager {
    override fun setFirstRun(value: Boolean) {
        preferencesHelper.setFirstRun(value)
    }

    override fun getFirstRun(): Boolean =
        preferencesHelper.getFirstRun()


    override fun insert(myDatabase: MyDatabase) {
        database.myDatabaseDao().insert(myDatabase)
    }

    override fun getAll(): Flowable<List<MyDatabase>> =
            database.myDatabaseDao().getAll()
}
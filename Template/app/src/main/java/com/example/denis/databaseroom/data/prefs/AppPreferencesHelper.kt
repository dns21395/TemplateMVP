package com.example.denis.databaseroom.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.denis.databaseroom.di.ApplicationContext
import com.example.denis.databaseroom.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by denis on 13/12/2017.
 */
@Singleton
class AppPreferencesHelper
    @Inject constructor(@ApplicationContext val context: Context,
                        @PreferenceInfo private val prefFileName: String): PreferencesHelper {


    private val prefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    private val PREF_FIRST_RUN = "FIRST_RUN"

    override fun setFirstRun(value: Boolean) {
        prefs.edit().putBoolean(PREF_FIRST_RUN, value).apply()
    }

    override fun getFirstRun(): Boolean =
        prefs.getBoolean(PREF_FIRST_RUN, false)



}
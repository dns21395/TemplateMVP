package com.example.denis.kotlinmvp.model.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.denis.kotlinmvp.di.PreferenceInfo
import javax.inject.Inject

/**
 * Created by denis on 26/01/2018.
 */
class AppPreferenceHelper
@Inject constructor(context: Context,
                    @PreferenceInfo private val prefFileName: String): PreferenceHelper {

    companion object {
        private val PREF_NAME = "PREF_CITY"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override var userName : String
        get() = prefs.getString(PREF_NAME, "noname")

        set(value) {
            prefs.edit().putString(PREF_NAME, value).apply()
        }
}
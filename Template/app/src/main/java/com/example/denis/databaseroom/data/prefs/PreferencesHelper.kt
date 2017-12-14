package com.example.denis.databaseroom.data.prefs

/**
 * Created by denis on 13/12/2017.
 */
interface PreferencesHelper {
    fun setFirstRun(value: Boolean)

    fun getFirstRun(): Boolean
}
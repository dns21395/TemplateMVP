package com.example.denis.databaseroom.data

import com.example.denis.databaseroom.data.db.helpers.MyDatabaseHelper
import com.example.denis.databaseroom.data.prefs.PreferencesHelper

/**
 * Created by denis on 13/12/2017.
 */
interface DataManager: MyDatabaseHelper, PreferencesHelper {
}
package com.example.denis.databaseroom.utils

import android.app.Activity
import com.example.denis.databaseroom.App

/**
 * Created by denis on 13/12/2017.
 */
val Activity.app: App
    get() = application as App
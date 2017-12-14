package com.example.denis.databaseroom.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

/**
 * Created by denis on 14/12/2017.
 */
fun getApplicationName(context: Context, pack: String): String {
    val packageManager = context.packageManager

    var applicationInfo: ApplicationInfo? = null

    try {
        applicationInfo = packageManager.getApplicationInfo(pack, 0)
    } catch (e: PackageManager.NameNotFoundException) {
    }

    return if (applicationInfo != null) packageManager.getApplicationLabel(applicationInfo).toString() else "(unknown)"

}
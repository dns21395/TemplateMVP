package com.example.denis.kotlinmvp.model

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.example.denis.kotlinmvp.model.model.AppInfo
import javax.inject.Inject

/**
 * Created by denis on 29/01/2018.
 */
class ApplicationInfoManager
    @Inject internal constructor(val context: Context) {

    fun getApplicationInfoArray(): ArrayList<AppInfo> {
        val array = ArrayList<AppInfo>()
        val packageManager = context.packageManager

        for(item in packageManager.getInstalledApplications(PackageManager.GET_META_DATA)) {
            try {
                if(null != packageManager.getLaunchIntentForPackage(item.packageName)) {
                    array.add(AppInfo(item.packageName, getApplicationName(context, item.packageName)))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return array
    }

    private fun getApplicationName(context: Context, pack: String): String {
        val packageManager = context.packageManager

        var applicationInfo: ApplicationInfo? = null

        try {
            applicationInfo = packageManager.getApplicationInfo(pack, 0)
        } catch (e: PackageManager.NameNotFoundException) {
        }

        return if (applicationInfo != null) packageManager.getApplicationLabel(applicationInfo).toString() else "(unknown)"

    }

}
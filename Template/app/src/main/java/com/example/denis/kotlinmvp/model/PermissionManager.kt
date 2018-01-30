package com.example.denis.kotlinmvp.model

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import javax.inject.Inject

/**
 * Created by denis on 29/01/2018.
 */
class PermissionManager @Inject internal constructor(val context: Context) {

    companion object {
        val REQUEST_CODE = 1337
    }

    private val TAG = "PermissionManager"

    fun permissionReadExternalStorageCheck(): Boolean {
        return ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    fun requestReadExternalStoragePermission(activity: Activity) {
        if(!permissionReadExternalStorageCheck()) {
            Log.d(TAG, "request")
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE)
        }
    }

    fun openSettings(activity: Activity) {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", context.packageName, null)
        intent.data = uri
        activity.startActivityForResult(intent, REQUEST_CODE)
    }
}
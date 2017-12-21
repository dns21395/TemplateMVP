package com.example.denis.databaseroom.utils

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import com.squareup.picasso.Picasso
import com.squareup.picasso.Request
import com.squareup.picasso.RequestHandler

/**
 * Created by denis on 18/12/2017.
 */
class AppIconRequestHandler(val context: Context) : RequestHandler() {
    val packageManager = context.packageManager



    companion object {
        val SCHEME_APP_ICON = "app-icon"

        private val TAG = "AppIconRequestHandler"


        fun getUri(packageName: String): Uri {
            return Uri.fromParts(SCHEME_APP_ICON, packageName, null)
        }
    }

    override fun canHandleRequest(data: Request): Boolean {
        return (SCHEME_APP_ICON.equals(data.uri.scheme))
    }

    override fun load(request: Request, networkPolicy: Int): Result? {
        val packageName = request.uri.schemeSpecificPart

        var drawable: Drawable? = null
        try {
            drawable = packageManager.getApplicationIcon(packageName)
        } catch (ignored: PackageManager.NameNotFoundException) {
            return null
        }

        val bitmap = (drawable as BitmapDrawable).bitmap


        return Result(Bitmap.createScaledBitmap(bitmap, 120, 120, false), Picasso.LoadedFrom.DISK)
    }




}
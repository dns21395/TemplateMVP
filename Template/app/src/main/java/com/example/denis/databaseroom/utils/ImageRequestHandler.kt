package com.example.denis.databaseroom.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import com.squareup.picasso.Picasso
import com.squareup.picasso.Request
import com.squareup.picasso.RequestHandler
import java.io.File

/**
 * Created by denis on 21/12/2017.
 */
class ImageRequestHandler(val context: Context) : RequestHandler() {
    override fun canHandleRequest(data: Request): Boolean {
        return SCHEME_PHOTO.equals(data.uri.scheme)
    }

    private val TAG = "ImageRequestHandler"

    companion object {
        val SCHEME_PHOTO = "photo"

        private val TAG = "ImageRequestHandler"

        fun getUri(photoPath: String): Uri {
            return Uri.fromParts(SCHEME_PHOTO, photoPath, null)
        }
    }

    override fun load(request: Request, networkPolicy: Int): Result {
        val imagePath = request.uri.schemeSpecificPart


        val file = File(imagePath)
        val imageUri = Uri.fromFile(file)

        val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)

        return Result(createChangedSizeBitmap(bitmap), Picasso.LoadedFrom.DISK)
    }

    private fun createChangedSizeBitmap(bitmap: Bitmap): Bitmap {
        val bitmapWidthRatio = bitmap.width / 500
        val bitmapHeightRatio = bitmap.height / 500

        if(bitmapWidthRatio <= 1 && bitmapHeightRatio <= 1) {
            return Bitmap.createScaledBitmap(bitmap, bitmap.width, bitmap.height, false)
        }

        if(bitmapWidthRatio <= 1 && bitmapHeightRatio > 1) {
            return Bitmap.createScaledBitmap(bitmap, bitmap.width / bitmapWidthRatio, bitmap.height / bitmapWidthRatio, false)
        }

        if(bitmapHeightRatio <= 1 && bitmapWidthRatio > 1) {
            return Bitmap.createScaledBitmap(bitmap, bitmap.width / bitmapHeightRatio, bitmap.height / bitmapHeightRatio, false)
        }

        return when(bitmapWidthRatio > bitmapHeightRatio) {
            true -> Bitmap.createScaledBitmap(bitmap, bitmap.width / bitmapWidthRatio, bitmap.height / bitmapWidthRatio, false)
            else ->  Bitmap.createScaledBitmap(bitmap, bitmap.width / bitmapHeightRatio, bitmap.height / bitmapHeightRatio, false)
        }
    }

}
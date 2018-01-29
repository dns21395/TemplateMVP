package com.example.denis.kotlinmvp.model

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import com.example.denis.kotlinmvp.model.model.GalleryImage
import java.io.File
import java.io.IOException
import javax.inject.Inject

/**
 * Created by denis on 29/01/2018.
 */
class GalleryManager @Inject internal constructor(val context: Context) {
    fun getImages(): ArrayList<GalleryImage> {
        val images = ArrayList<GalleryImage>()

        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.MediaColumns.DATA)

        val cursor = context.contentResolver.query(
                uri,
                projection,
                null,
                null,
                null
        )

        cursor.moveToFirst()
        while(cursor.moveToNext()) {
            try {
                val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
                val photo = GalleryImage(null)
                photo.uri = Uri.fromFile(File(cursor.getString(columnIndex)))
                images.add(photo)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        cursor.close()

        return images
    }
}
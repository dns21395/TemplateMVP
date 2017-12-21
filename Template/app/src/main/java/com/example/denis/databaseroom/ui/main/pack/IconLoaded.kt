package com.example.denis.databaseroom.ui.main.pack

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target




/**
 * Created by denis on 21/12/2017.
 */
class IconLoaded(val image: ImageView, val callback: PackageAdapter.Callback) : Target {
    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

    }

    override fun onBitmapFailed(errorDrawable: Drawable?) {
    }

    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
        image.setImageBitmap(bitmap)
        callback.updateTexts()
    }
}
package com.example.denis.databaseroom.ui.gallery.photos

import android.net.Uri

/**
 * Created by denis on 21/12/2017.
 */
class ImageGallery {
    private var uri: Uri? = null
    fun getUri(): Uri? {
        return uri
    }

    fun setUri(uri: Uri) {
        this.uri = uri
    }
}
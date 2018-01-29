package com.example.denis.kotlinmvp.ui.main.gallery.view

import com.example.denis.kotlinmvp.model.model.GalleryImage
import com.example.denis.kotlinmvp.ui.base.view.MVPView

/**
 * Created by denis on 29/01/2018.
 */
interface GalleryMVPView : MVPView {
    fun displayGalleryImages(array: ArrayList<GalleryImage>)
}
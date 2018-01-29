package com.example.denis.kotlinmvp.ui.main.gallery.interactor

import com.example.denis.kotlinmvp.model.model.GalleryImage
import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor

/**
 * Created by denis on 29/01/2018.
 */
interface GalleryMVPInteractor : MVPInteractor {
    fun getGalleryImages(): ArrayList<GalleryImage>
}
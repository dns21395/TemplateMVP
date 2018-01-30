package com.example.denis.kotlinmvp.ui.main.fragments.gallery.interactor

import com.example.denis.kotlinmvp.model.GalleryManager
import com.example.denis.kotlinmvp.model.model.GalleryImage
import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by denis on 29/01/2018.
 */
class GalleryInteractor  @Inject internal constructor(private val galleryManager: GalleryManager, preferenceHelper: PreferenceHelper)
    :  BaseInteractor(preferenceHelper), GalleryMVPInteractor {
    override fun getGalleryImages(): ArrayList<GalleryImage> = galleryManager.getImages()

}
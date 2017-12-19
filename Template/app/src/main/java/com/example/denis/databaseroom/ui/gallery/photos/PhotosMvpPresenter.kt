package com.example.denis.databaseroom.ui.gallery.photos

import com.example.denis.databaseroom.ui.base.MvpPresenter

/**
 * Created by denis on 19/12/2017.
 */
interface PhotosMvpPresenter<V: PhotosMvpView> : MvpPresenter<V> {
    fun getImages()
}
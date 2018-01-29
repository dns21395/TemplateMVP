package com.example.denis.kotlinmvp.ui.main.gallery.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.gallery.interactor.GalleryMVPInteractor
import com.example.denis.kotlinmvp.ui.main.gallery.view.GalleryMVPView

/**
 * Created by denis on 29/01/2018.
 */
interface GalleryMVPPresenter<V : GalleryMVPView, I : GalleryMVPInteractor> : MVPPresenter<V, I> {
}
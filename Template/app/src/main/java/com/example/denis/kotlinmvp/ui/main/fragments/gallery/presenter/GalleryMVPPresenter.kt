package com.example.denis.kotlinmvp.ui.main.fragments.gallery.presenter

import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.interactor.GalleryMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.view.GalleryMVPView

/**
 * Created by denis on 29/01/2018.
 */
interface GalleryMVPPresenter<V : GalleryMVPView, I : GalleryMVPInteractor> : MVPPresenter<V, I> {
}
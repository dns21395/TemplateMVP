package com.example.denis.kotlinmvp.ui.main.fragments.gallery

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import com.example.denis.kotlinmvp.model.GalleryManager
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.interactor.GalleryInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.interactor.GalleryMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.presenter.GalleryMVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.presenter.GalleryPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.view.GalleryAdapter
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.view.GalleryFragment
import com.example.denis.kotlinmvp.ui.main.fragments.gallery.view.GalleryMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by denis on 29/01/2018.
 */
@Module
class GalleryFragmentModule {
    @Provides
    internal fun provideGalleryInteractor(interactor: GalleryInteractor): GalleryMVPInteractor = interactor

    @Provides
    internal fun provideGalleryPresenter(presenter: GalleryPresenter<GalleryMVPView, GalleryMVPInteractor>)
        : GalleryMVPPresenter<GalleryMVPView, GalleryMVPInteractor> = presenter

    @Provides
    internal fun provideLayoutManager(fragment: GalleryFragment): GridLayoutManager = GridLayoutManager(fragment.activity, 3)

    @Provides
    internal fun provideGalleryManager(context: Context): GalleryManager = GalleryManager(context)

    @Provides
    internal fun provideGalleryAdapter(context: Context): GalleryAdapter = GalleryAdapter(context)

}
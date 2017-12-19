package com.example.denis.databaseroom.ui.gallery

import android.support.v4.app.Fragment
import com.example.denis.databaseroom.ui.base.MvpView

/**
 * Created by denis on 19/12/2017.
 */
interface GalleryMvpView : MvpView {
    fun setupToolbar()

    fun setFragmentLayout(fragment: Fragment)

    fun permissionCheck(): Boolean

}
package com.example.denis.databaseroom.ui.gallery.photos

import com.example.denis.databaseroom.ui.base.MvpView

/**
 * Created by denis on 19/12/2017.
 */
interface PhotosMvpView : MvpView {
    fun setupRecyclerView()

    fun updateRecyclerView(array: ArrayList<String>)

}
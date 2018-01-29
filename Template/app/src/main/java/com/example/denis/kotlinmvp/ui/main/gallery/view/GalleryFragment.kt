package com.example.denis.kotlinmvp.ui.main.gallery.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.model.GalleryImage
import com.example.denis.kotlinmvp.ui.base.view.BaseFragment
import com.example.denis.kotlinmvp.ui.main.gallery.interactor.GalleryMVPInteractor
import com.example.denis.kotlinmvp.ui.main.gallery.presenter.GalleryMVPPresenter
import kotlinx.android.synthetic.main.fragment_gallery.*
import javax.inject.Inject

/**
 * Created by denis on 29/01/2018.
 */
class GalleryFragment : BaseFragment(), GalleryMVPView {

    companion object {
        fun newInstance(): GalleryFragment = GalleryFragment()
    }

    @Inject lateinit var presenter: GalleryMVPPresenter<GalleryMVPView, GalleryMVPInteractor>
    @Inject lateinit var adapter: GalleryAdapter
    @Inject lateinit var layoutManager: GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_gallery, container, false)

    override fun setUp() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun displayGalleryImages(array: ArrayList<GalleryImage>) {
        adapter.updateArray(array)
    }
}
package com.example.denis.databaseroom.ui.gallery.photos

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_photos.*
import javax.inject.Inject

/**
 * Created by denis on 19/12/2017.
 */
class PhotosFragment : BaseFragment(), PhotosMvpView {
    companion object {
        fun newInstance(): PhotosFragment {
            val args = Bundle()
            val fragment = PhotosFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val TAG = "PhotosFragment"

    @Inject lateinit var presenter: PhotosMvpPresenter<PhotosMvpView>

    @Inject lateinit var adapter: PhotosAdapter

    val layoutManager = GridLayoutManager(context, 3)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_photos, container, false)

        val component = getActivityComponent()

        component?.inject(this)
        presenter.onAttach(this)

        return view

    }

    override fun setUp(view: View?) {
        setupRecyclerView()
    }

    override fun setupRecyclerView() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        adapter.setRecyclerLayoutManager(recyclerView, layoutManager)

        presenter.getImages()
    }

    override fun updateRecyclerView(array: ArrayList<ImageGallery>) {
        adapter.insertItems(array)
    }
}
package com.example.denis.databaseroom.ui.gallery.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.ui.base.BaseFragment
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

    @Inject lateinit var presenter: PhotosMvpPresenter<PhotosMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_photos, container, false)

        val component = getActivityComponent()

        component?.inject(this)
        presenter.onAttach(this)

        return view

    }

    override fun setUp(view: View?) {

    }
}
package com.example.denis.databaseroom.ui.gallery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.ui.base.BaseActivity
import com.example.denis.databaseroom.ui.gallery.photos.PhotosFragment
import kotlinx.android.synthetic.main.activity_gallery.*
import javax.inject.Inject

/**
 * Created by denis on 19/12/2017.
 */
class GalleryActivity : BaseActivity(), GalleryMvpView {
    companion object {
        fun getStartInject(context: Context): Intent = Intent(context, GalleryActivity::class.java)
    }


    @Inject lateinit var presenter: GalleryMvpPresenter<GalleryMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        activityComponent.inject(this)

        presenter.onAttach(this)

        setUp()
    }

    override fun setUp() {
        setupToolbar()
        setFragmentLayout(PhotosFragment.newInstance())
    }

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
        toolbarTitle.text = applicationContext.resources.getString(R.string.gallery)
    }

    override fun setFragmentLayout(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }
}
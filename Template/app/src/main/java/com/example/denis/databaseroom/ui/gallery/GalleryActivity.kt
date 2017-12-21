package com.example.denis.databaseroom.ui.gallery

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.ui.base.BaseActivity
import com.example.denis.databaseroom.ui.gallery.empty.EmptyFragment
import com.example.denis.databaseroom.ui.gallery.photos.PhotosFragment
import kotlinx.android.synthetic.main.activity_gallery.*
import java.util.jar.Manifest
import javax.inject.Inject

/**
 * Created by denis on 19/12/2017.
 */
class GalleryActivity : BaseActivity(), GalleryMvpView {
    companion object {
        fun getStartInject(context: Context): Intent = Intent(context, GalleryActivity::class.java)
    }

    private val TAG = "GalleryActivity"

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

        when(permissionCheck()) {
            true -> setFragmentLayout(PhotosFragment.newInstance())
            false -> setFragmentLayout(EmptyFragment.newInstance())
        }
    }

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
        toolbarTitle.text = applicationContext.resources.getString(R.string.gallery)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return false
    }


    override fun setFragmentLayout(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commitAllowingStateLoss()
    }

    override fun permissionCheck(): Boolean {
         return ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            1337 -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setFragmentLayout(PhotosFragment.newInstance())
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            1338 -> {
                when(permissionCheck()) {
                    true -> setFragmentLayout(PhotosFragment.newInstance())
                    false -> setFragmentLayout(EmptyFragment.newInstance())
                }
            }
        }
    }
}
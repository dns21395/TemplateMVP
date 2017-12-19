package com.example.denis.databaseroom.ui.gallery.empty

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.databaseroom.R
import com.example.denis.databaseroom.ui.base.BaseFragment
import com.example.denis.databaseroom.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_empty.*
import javax.inject.Inject

/**
 * Created by denis on 19/12/2017.
 */
class EmptyFragment : BaseFragment(), EmptyMvpView {
    companion object {
        fun newInstance(): EmptyFragment {
            val args = Bundle()
            val fragment = EmptyFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val TAG = "EmptyFragment"

    @Inject lateinit var presenter: EmptyMvpPresenter<EmptyMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_empty, container, false)

        val component = getActivityComponent()

        component?.inject(this)
        presenter.onAttach(this)

        return view

    }

    override fun setUp(view: View?) {
        permission.setOnClickListener {
            Log.d(TAG, "${shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)}")
            when(shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                true -> openSettings()
                else -> requestPermission()
            }
        }
    }

    override fun requestPermission() {
        ActivityCompat.requestPermissions(activity as Activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1337)
    }

    override fun openSettings() {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", context?.packageName, null)
        intent.data = uri
        activity?.startActivityForResult(intent, 1338)

    }
}
package com.example.denis.kotlinmvp.ui.main.fragments.permission.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.ui.base.view.BaseFragment
import com.example.denis.kotlinmvp.ui.main.fragments.permission.interactor.PermissionInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.permission.presenter.PermissionPresenter
import kotlinx.android.synthetic.main.fragment_permission.*
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PermissionFragment : BaseFragment(), PermissionMVPView {

    companion object {
        fun newInstance(): PermissionFragment = PermissionFragment()
    }

    @Inject lateinit var presenter: PermissionPresenter<PermissionMVPView, PermissionInteractor>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_permission, container, false)

    override fun setUp() {
        permission.setOnClickListener {
            getBaseActivity()?.let {
                presenter.onGivePermissionClicked(it)
            }
        }

        presenter.requestPermission(getBaseActivity()!!)
    }
}
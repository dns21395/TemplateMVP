package com.example.denis.kotlinmvp.ui.main.application.view

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.model.AppInfo
import com.example.denis.kotlinmvp.ui.base.view.BaseFragment
import com.example.denis.kotlinmvp.ui.main.application.interactor.ApplicationInteractor
import com.example.denis.kotlinmvp.ui.main.application.presenter.ApplicationPresenter
import kotlinx.android.synthetic.main.fragment_application.*
import javax.inject.Inject

/**
 * Created by denis on 28/01/2018.
 */
class ApplicationFragment : BaseFragment(), ApplicationMVPView {

    companion object {
        fun newInstance(): ApplicationFragment = ApplicationFragment()
    }

    @Inject lateinit var presenter: ApplicationPresenter<ApplicationMVPView, ApplicationInteractor>

    @Inject lateinit var adapter: ApplicationAdapter

    @Inject lateinit var layoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_application, container, false)

    override fun setUp() {
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, layoutManager.orientation))
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun displayApplications(array: ArrayList<AppInfo>) {
        array.let {
            adapter.updateData(it)
        }
    }
}
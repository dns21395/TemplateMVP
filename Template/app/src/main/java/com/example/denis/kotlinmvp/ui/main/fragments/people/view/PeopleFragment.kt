package com.example.denis.kotlinmvp.ui.main.fragments.people.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.ui.base.view.BaseFragment
import com.example.denis.kotlinmvp.ui.main.fragments.people.interactor.PeopleMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.presenter.PeopleMVPPresenter
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PeopleFragment : BaseFragment(), PeopleMVPView {

    companion object {
        fun newInstance(): PeopleFragment = PeopleFragment()
    }

    @Inject lateinit var presenter: PeopleMVPPresenter<PeopleMVPView, PeopleMVPInteractor>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_people, container, false)

    override fun setUp() {

    }
}
package com.example.denis.kotlinmvp.ui.main.fragments.people.view

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.denis.kotlinmvp.R
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.ui.base.view.BaseFragment
import com.example.denis.kotlinmvp.ui.main.fragments.people.interactor.PeopleMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.view.InsertPersonDialog
import com.example.denis.kotlinmvp.ui.main.fragments.people.presenter.PeopleMVPPresenter
import kotlinx.android.synthetic.main.fragment_people.*
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PeopleFragment : BaseFragment(), PeopleMVPView, PeopleAdapter.Callback {


    companion object {
        fun newInstance(): PeopleFragment = PeopleFragment()
    }

    @Inject lateinit var presenter: PeopleMVPPresenter<PeopleMVPView, PeopleMVPInteractor>

    @Inject lateinit var adapter: PeopleAdapter

    @Inject lateinit var layoutManager: LinearLayoutManager


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_people, container, false)

    override fun setUp() {
        fab.setOnClickListener {
            showDialog(InsertPersonDialog.newInstance(), InsertPersonDialog.TAG)
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, layoutManager.orientation))
        recyclerView.adapter = adapter
        adapter.callback = this
        adapter.itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun showDialog(dialog: DialogFragment, tag: String) {
        dialog.show(getBaseActivity()?.supportFragmentManager, tag)
    }

    override fun displayPeople(array: ArrayList<Person>) {
        adapter.updateArray(array)
    }

    override fun onRemovePerson(person: Person) {
        presenter.removePerson(person)
    }


}
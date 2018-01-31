package com.example.denis.kotlinmvp.ui.main.fragments.people.person.presenter

import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.ui.base.presenter.MVPPresenter
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.interactor.InsertPersonMVPInteractor
import com.example.denis.kotlinmvp.ui.main.fragments.people.person.view.InsertPersonMVPView

/**
 * Created by denis on 31/01/2018.
 */
interface InsertPersonMVPPresenter<V: InsertPersonMVPView, I : InsertPersonMVPInteractor> : MVPPresenter<V, I> {
    fun onButtonAddClicked(name: String, age: Int?)
}
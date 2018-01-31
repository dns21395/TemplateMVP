package com.example.denis.kotlinmvp.ui.main.fragments.people.interactor

import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor

/**
 * Created by denis on 30/01/2018.
 */
interface PeopleMVPInteractor : MVPInteractor {
    fun getPersons(): List<Person>
}
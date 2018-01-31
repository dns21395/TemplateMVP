package com.example.denis.kotlinmvp.ui.main.fragments.people.person.interactor

import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor

/**
 * Created by denis on 31/01/2018.
 */
interface InsertPersonMVPInteractor : MVPInteractor {
    fun insertPerson(person: Person)
}
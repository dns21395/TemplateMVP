package com.example.denis.kotlinmvp.ui.main.fragments.people.person.interactor

import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.model.database.repository.person.PersonRepo
import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * Created by denis on 31/01/2018.
 */
class InsertPersonInteractor @Inject internal constructor(private val personRepo: PersonRepo, preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), InsertPersonMVPInteractor {

    override fun insertPerson(person: Person) {
        personRepo.insertPerson(person)
    }
}
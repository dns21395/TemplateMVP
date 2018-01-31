package com.example.denis.kotlinmvp.ui.main.fragments.people.interactor

import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.model.database.repository.person.PersonRepo
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PeopleInteractor @Inject internal constructor(private val personRepo: PersonRepo, preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), PeopleMVPInteractor {
    override fun getPersons(): List<Person> = personRepo.getAllPerson()

}
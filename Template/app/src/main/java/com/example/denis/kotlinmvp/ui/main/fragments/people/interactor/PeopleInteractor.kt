package com.example.denis.kotlinmvp.ui.main.fragments.people.interactor

import com.example.denis.kotlinmvp.model.database.repository.age.Age
import com.example.denis.kotlinmvp.model.database.repository.age.AgeRepo
import com.example.denis.kotlinmvp.model.database.repository.name.Name
import com.example.denis.kotlinmvp.model.database.repository.name.NameRepo
import com.example.denis.kotlinmvp.model.preferences.PreferenceHelper
import com.example.denis.kotlinmvp.ui.base.interactor.BaseInteractor
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.model.database.repository.person.PersonRepo
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PeopleInteractor
    @Inject internal constructor(private val personRepo: PersonRepo,
                                 private val ageRepo: AgeRepo,
                                 private val nameRepo: NameRepo,
                                 preferenceHelper: PreferenceHelper)
    : BaseInteractor(preferenceHelper), PeopleMVPInteractor {


    override fun removePerson(person: Person) {
        personRepo.removePerson(person)
    }

    override fun getPersons(): Flowable<List<Person>> = personRepo.getAllPerson()

    override fun getPersonsAge(): Flowable<List<Age>> = ageRepo.loadAll()

    override fun getPersonsName(): Flowable<List<Name>> = nameRepo.loadNames()


}
package com.example.denis.kotlinmvp.ui.main.fragments.people.interactor

import com.example.denis.kotlinmvp.model.database.repository.age.Age
import com.example.denis.kotlinmvp.model.database.repository.name.Name
import com.example.denis.kotlinmvp.model.database.repository.person.Person
import com.example.denis.kotlinmvp.ui.base.interactor.MVPInteractor
import io.reactivex.Flowable

/**
 * Created by denis on 30/01/2018.
 */
interface PeopleMVPInteractor : MVPInteractor {
    fun getPersons(): Flowable<List<Person>>

    fun getPersonsAge(): Flowable<List<Age>>

    fun getPersonsName(): Flowable<List<Name>>

    fun removePerson(person: Person)


}
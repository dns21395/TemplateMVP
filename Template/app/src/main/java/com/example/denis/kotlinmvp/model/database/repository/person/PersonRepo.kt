package com.example.denis.kotlinmvp.model.database.repository.person

import io.reactivex.Flowable

/**
 * Created by denis on 30/01/2018.
 */
interface PersonRepo {
    fun getAllPerson(): Flowable<List<Person>>

    fun insertPerson(person: Person)

    fun removePerson(person: Person)
}
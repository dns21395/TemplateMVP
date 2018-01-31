package com.example.denis.kotlinmvp.model.database.repository.person

import com.example.denis.kotlinmvp.model.database.repository.age.Age
import com.example.denis.kotlinmvp.model.database.repository.age.AgeDao
import com.example.denis.kotlinmvp.model.database.repository.name.Name
import com.example.denis.kotlinmvp.model.database.repository.name.NameDao
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class PersonRepository
    @Inject internal constructor(private val personDao: PersonDao,
                                 private val nameDao: NameDao,
                                 private val ageDao: AgeDao)
    : PersonRepo {

    override fun getAllPerson(): Flowable<List<Person>> = personDao.getAllPerson()

    override fun insertPerson(person: Person) {
        val ageId = ageDao.insert(Age(0, person.age))
        val nameId = nameDao.insert(Name(0, person.name))
        personDao.insert(PersonId(0, nameId, ageId))
    }

}
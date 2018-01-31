package com.example.denis.kotlinmvp.model.database.repository.age

import javax.inject.Inject

/**
 * Created by denis on 30/01/2018.
 */
class AgeRepository @Inject internal constructor(private val ageDao: AgeDao) : AgeRepo {
    override fun loadAll(): List<Age> = ageDao.loadAll()

    override fun insert(age: Age) {
        ageDao.insert(age)
    }

}
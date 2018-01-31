package com.example.denis.kotlinmvp.model.database.repository.name

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by denis on 26/01/2018.
 */
class NameRepository @Inject internal constructor(private val nameDao: NameDao) : NameRepo {
    override fun loadNames(): List<Name> = nameDao.loadAll()

    override fun insertName(name: Name) {
        nameDao.insert(name)
    }

    override fun isNameRepoEmpty(): Boolean = nameDao.loadAll().isEmpty()
}
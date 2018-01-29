package com.example.denis.kotlinmvp.model.database.repository.names

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by denis on 26/01/2018.
 */
class NameRepository @Inject internal constructor(private val nameDao: NameDao) : NameRepo {
    override fun loadNames(): Observable<List<Name>> = Observable.fromCallable { nameDao.loadAll() }

    override fun insertName(name: Name): Observable<Boolean> {
        nameDao.insert(name)
        return Observable.just(true)
    }

    override fun isNameRepoEmpty(): Observable<Boolean> = Observable.fromCallable { nameDao.loadAll().isEmpty() }
}
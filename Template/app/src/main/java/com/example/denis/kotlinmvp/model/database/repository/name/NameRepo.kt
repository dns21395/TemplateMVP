package com.example.denis.kotlinmvp.model.database.repository.name

import io.reactivex.Flowable


/**
 * Created by denis on 26/01/2018.
 */
interface NameRepo {
    fun loadNames(): Flowable<List<Name>>

    fun insertName(name: Name)

}
package com.example.denis.kotlinmvp.model.database.repository.age

import io.reactivex.Flowable

/**
 * Created by denis on 30/01/2018.
 */
interface AgeRepo {
    fun loadAll(): Flowable<List<Age>>
    fun insert(age: Age)

}
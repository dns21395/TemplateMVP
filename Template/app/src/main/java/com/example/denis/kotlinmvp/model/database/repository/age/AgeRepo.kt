package com.example.denis.kotlinmvp.model.database.repository.age

/**
 * Created by denis on 30/01/2018.
 */
interface AgeRepo {
    fun loadAll(): List<Age>
    fun insert(age: Age)

}
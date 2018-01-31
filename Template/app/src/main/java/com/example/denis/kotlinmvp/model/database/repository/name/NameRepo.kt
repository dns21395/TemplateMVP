package com.example.denis.kotlinmvp.model.database.repository.name


/**
 * Created by denis on 26/01/2018.
 */
interface NameRepo {
    fun loadNames(): List<Name>

    fun insertName(name: Name)

    fun isNameRepoEmpty(): Boolean
}
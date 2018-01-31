package com.example.denis.kotlinmvp.model.database.repository.person

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by denis on 30/01/2018.
 */
@Dao
interface PersonDao {
    @Insert
    fun insert(personId: PersonId): Long

    @Query("SELECT person.id, name.name, age.age FROM person " +
            "INNER JOIN name ON person.nameId = name.id " +
            "INNER JOIN age ON person.ageId = age.id ")
    fun getAllPerson(): List<Person>
}
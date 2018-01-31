package com.example.denis.kotlinmvp.model.database.repository.person

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Created by denis on 30/01/2018.
 */
@Dao
interface PersonDao {
    @Insert
    fun insert(personId: PersonId): Long

    @Query("SELECT person_id.id, name.name, age.age FROM person_id " +
            "INNER JOIN name ON person_id.nameId = name.id " +
            "INNER JOIN age ON person_id.ageId = age.id " +
            "ORDER BY person_id.id DESC")
    fun getAllPerson(): Flowable<List<Person>>
}
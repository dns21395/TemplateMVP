package com.example.denis.kotlinmvp.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.denis.kotlinmvp.model.database.repository.age.Age
import com.example.denis.kotlinmvp.model.database.repository.age.AgeDao
import com.example.denis.kotlinmvp.model.database.repository.name.Name
import com.example.denis.kotlinmvp.model.database.repository.name.NameDao
import com.example.denis.kotlinmvp.model.database.repository.person.PersonDao
import com.example.denis.kotlinmvp.model.database.repository.person.PersonId

/**
 * Created by denis on 26/01/2018.
 */
@Database(entities = [(Age::class), (Name::class), (PersonId::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ageDao(): AgeDao

    abstract fun nameDao(): NameDao

    abstract fun personDao(): PersonDao
}
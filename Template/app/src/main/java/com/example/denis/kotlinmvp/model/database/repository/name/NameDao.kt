package com.example.denis.kotlinmvp.model.database.repository.name

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by denis on 26/01/2018.
 */
@Dao
interface NameDao {
    @Insert
    fun insert(name: Name)

    @Query("SELECT * FROM names")
    fun loadAll(): List<Name>
}
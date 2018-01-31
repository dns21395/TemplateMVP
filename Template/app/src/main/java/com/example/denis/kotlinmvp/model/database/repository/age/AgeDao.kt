package com.example.denis.kotlinmvp.model.database.repository.age

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.denis.kotlinmvp.model.database.base.BaseDao

/**
 * Created by denis on 30/01/2018.
 */
@Dao
interface AgeDao : BaseDao<Age> {
    @Query("SELECT * FROM age")
    fun loadAll(): List<Age>
}
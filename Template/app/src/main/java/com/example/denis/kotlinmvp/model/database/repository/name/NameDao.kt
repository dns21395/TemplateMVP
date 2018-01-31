package com.example.denis.kotlinmvp.model.database.repository.name

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.denis.kotlinmvp.model.database.base.BaseDao

/**
 * Created by denis on 26/01/2018.
 */
@Dao
interface NameDao : BaseDao<Name> {
    @Query("SELECT * FROM name")
    fun loadAll(): List<Name>
}
package com.example.denis.kotlinmvp.model.database.repository.name

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.denis.kotlinmvp.model.database.base.BaseDao
import io.reactivex.Flowable

/**
 * Created by denis on 26/01/2018.
 */
@Dao
interface NameDao : BaseDao<Name> {
    @Query("SELECT * FROM name")
    fun loadAll(): Flowable<List<Name>>

    @Query("SELECT * FROM name WHERE id = :id LIMIT 1")
    fun getName(id: Long): Name
}
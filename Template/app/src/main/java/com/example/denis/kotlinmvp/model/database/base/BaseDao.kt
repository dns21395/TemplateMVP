package com.example.denis.kotlinmvp.model.database.base

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update

/**
 * Created by denis on 30/01/2018.
 */
interface BaseDao<T> {
    @Insert
    fun insert(obj: T): Long

    @Insert
    fun insert(vararg obj: T)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}
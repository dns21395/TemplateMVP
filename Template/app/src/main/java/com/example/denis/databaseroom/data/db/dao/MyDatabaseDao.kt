package com.example.denis.databaseroom.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.denis.databaseroom.data.db.model.MyDatabase
import io.reactivex.Flowable

/**
 * Created by denis on 13/12/2017.
 */
@Dao
interface MyDatabaseDao {
    @Query("SELECT * FROM MyDatabase")
    fun getAll(): Flowable<List<MyDatabase>>

    @Insert()
    fun insert(myDatabase: MyDatabase)
}
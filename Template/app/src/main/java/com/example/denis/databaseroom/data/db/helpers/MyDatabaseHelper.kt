package com.example.denis.databaseroom.data.db.helpers

import com.example.denis.databaseroom.data.db.model.MyDatabase
import io.reactivex.Flowable

/**
 * Created by denis on 13/12/2017.
 */
interface MyDatabaseHelper {
    fun getAll(): Flowable<List<MyDatabase>>

    fun insert(myDatabase: MyDatabase)
}
package com.example.denis.databaseroom.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.denis.databaseroom.data.db.dao.MyDatabaseDao
import com.example.denis.databaseroom.data.db.model.MyDatabase

/**
 * Created by denis on 13/12/2017.
 */
@Database(entities = arrayOf(MyDatabase::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun myDatabaseDao(): MyDatabaseDao
}
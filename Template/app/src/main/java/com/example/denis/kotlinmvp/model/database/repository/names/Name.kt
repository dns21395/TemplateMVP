package com.example.denis.kotlinmvp.model.database.repository.names

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by denis on 26/01/2018.
 */
@Entity(tableName = "names")
data class Name (
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "name")
    var name: String
)
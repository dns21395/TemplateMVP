package com.example.denis.kotlinmvp.model.database.repository.name

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by denis on 26/01/2018.
 */
@Entity(tableName = "name")
data class Name (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String
)
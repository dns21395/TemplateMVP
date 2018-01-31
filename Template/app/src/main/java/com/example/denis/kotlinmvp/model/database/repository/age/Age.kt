package com.example.denis.kotlinmvp.model.database.repository.age

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by denis on 26/01/2018.
 */

@Entity(tableName = "age")
data class Age (
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        var age: Int
)
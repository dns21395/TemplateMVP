package com.example.denis.kotlinmvp.model.database.repository.age

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.example.denis.kotlinmvp.model.database.repository.name.Name

/**
 * Created by denis on 26/01/2018.
 */
//@Entity(tableName = "age", foreignKeys = [(ForeignKey(entity = Name::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("name_id"),
//        onDelete = ForeignKey.CASCADE))])

@Entity(tableName = "age")
data class Age (
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        var age: Int
)
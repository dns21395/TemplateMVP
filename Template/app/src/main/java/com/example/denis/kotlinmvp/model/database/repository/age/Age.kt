package com.example.denis.kotlinmvp.model.database.repository.age

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.example.denis.kotlinmvp.model.database.repository.names.Name

/**
 * Created by denis on 26/01/2018.
 */
@Entity(tableName = "ages", foreignKeys = [(ForeignKey(entity = Name::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("name_id"),
        onDelete = ForeignKey.CASCADE))])
data class Age (
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "name_id")
        var nameId: Long,

        @ColumnInfo(name = "age")
        var age: Int
)
package com.example.denis.kotlinmvp.model.database.repository.person

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.example.denis.kotlinmvp.model.database.repository.age.Age
import com.example.denis.kotlinmvp.model.database.repository.name.Name

/**
 * Created by denis on 31/01/2018.
 */
@Entity(tableName = "person_id",
        foreignKeys =
        [
            (ForeignKey(entity = Name::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("nameId"),
                onDelete = ForeignKey.CASCADE)),

            (ForeignKey(entity = Age::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("ageId"),
                onDelete = ForeignKey.CASCADE))
        ])
data class PersonId(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val nameId: Long,
        val ageId: Long)
package com.example.denis.databaseroom.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by denis on 13/12/2017.
 */
@Entity
data class MyDatabase (
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val pack: String,
        val length: Long
) {
        override fun equals(other: Any?): Boolean {
                return id == (other as MyDatabase).id
        }

        override fun hashCode(): Int = id.toInt()
}
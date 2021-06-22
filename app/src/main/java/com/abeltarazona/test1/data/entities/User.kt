package com.abeltarazona.test1.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by AbelTarazona on 10/06/2021
 */

@Entity(tableName = "table_user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val password: String
)

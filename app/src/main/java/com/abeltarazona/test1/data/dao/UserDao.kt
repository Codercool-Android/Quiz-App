package com.abeltarazona.test1.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.abeltarazona.test1.data.entities.User

/**
 * Created by AbelTarazona on 15/06/2021
 */

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

}
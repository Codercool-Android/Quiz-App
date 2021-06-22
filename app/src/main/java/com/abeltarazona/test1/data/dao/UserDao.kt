package com.abeltarazona.test1.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abeltarazona.test1.data.entities.User

/**
 * Created by AbelTarazona on 15/06/2021
 */

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT  * FROM table_user WHERE name=:user AND password=:pass")
    fun login(user: String, pass: String) : List<User>

}
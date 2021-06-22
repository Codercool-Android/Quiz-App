package com.abeltarazona.test1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abeltarazona.test1.data.dao.UserDao
import com.abeltarazona.test1.data.entities.User

/**
 * Created by AbelTarazona on 15/06/2021
 */

@Database(entities = [User::class], exportSchema = false, version = 1)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {

        var instance: QuizDatabase? = null

        fun provideDatabase(context: Context): QuizDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context.applicationContext, QuizDatabase::class.java, "quiz_db")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance!!
        }

    }


}
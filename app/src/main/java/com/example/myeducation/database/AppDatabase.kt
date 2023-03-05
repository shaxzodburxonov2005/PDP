package com.example.myeducation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myeducation.dao.EducationDao
import com.example.myeducation.model.Course

@Database(entities = [Course::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun courseDao():EducationDao

    companion object{
        var instance:AppDatabase?=null
        fun getInstance(context: Context):AppDatabase{
            if (instance==null){
                instance=Room.databaseBuilder(context,AppDatabase::class.java,"education_dp")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }

}
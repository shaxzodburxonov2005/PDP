package com.example.myeducation.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.myeducation.model.Course

interface EducationDao {
    @Insert
    fun insertCourse(course: Course)

    @Query("SELECT * FROM Course")
    fun getAllCourse():List<Course>

    @Query("SELECT * FROM Course Where courseName= :name ")
    fun getCourseByName(name:String):Course


}
package com.example.myeducation.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myeducation.model.*
import io.reactivex.rxjava3.core.Flowable
import java.util.concurrent.Flow

@Dao
interface EducationDao {
    @Insert
    fun insertCourse(course: Course)

    @Query("SELECT * FROM Course")
    fun getAllCourse(): Flowable<List<Course>>

    @Query("SELECT * FROM Course Where courseName= :name ")
    fun getCourseByName(name: String): Course

    @Transaction
    @Query("SELECT * FROM Course")
    fun getCourseWithMentor(): Flowable<List<CourseWithMentor>>

    @Query("SELECT * FROM Mentor WHERE courseId = :courseId")
    fun getAllMentors(courseId: Int): Flowable<List<Mentor>>

    @Query("SELECT * FROM Group Where isOpen = :isOpen and courseId = :courseId")
    fun getAllGroup(isOpen: Boolean, courseId: Int): Flowable<List<Group>>




    @Insert
    fun insertGroup(vararg group: Group)

    @Insert
    fun insertMentor(mentor: Mentor)


}
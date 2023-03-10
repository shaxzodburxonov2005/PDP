package com.example.myeducation.model

import androidx.room.Embedded
import androidx.room.Relation
import io.reactivex.rxjava3.core.Flowable

data class CourseWithMentor(
    @Embedded val course: Course,
    @Relation(
        parentColumn = "id",
        entityColumn = "courseId"
    )
    val listMentor:List<Mentor>
):java.io.Serializable

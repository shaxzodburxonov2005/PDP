package com.example.myeducation.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Course(
    @PrimaryKey(autoGenerate = true)
    var courseId:Int?=null,
    var courseName:String?,
    var courseDescription:String?,

)

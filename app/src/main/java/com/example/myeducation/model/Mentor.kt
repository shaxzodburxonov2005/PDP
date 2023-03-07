package com.example.myeducation.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mentor(
    @PrimaryKey(autoGenerate = true)
    var mentorId:Int?=null,
    var mentorName:String?,
    var sName:String?,
    var fathersName:String?,
    var courseId:Int

)

package com.example.myeducation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var gName:String?,
    var data:String?,
    var day:String?,
)

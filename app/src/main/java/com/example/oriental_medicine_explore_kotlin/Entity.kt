package com.example.oriental_medicine_explore_kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Entity(
    @PrimaryKey(autoGenerate = true)//PrimatyKey를 자동적으로 생산
    val id:Int,
    var number1:String
)

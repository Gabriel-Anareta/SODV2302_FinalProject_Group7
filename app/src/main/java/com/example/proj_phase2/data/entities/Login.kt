package com.example.proj_phase2.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Logins")
data class Login(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val password: String
)

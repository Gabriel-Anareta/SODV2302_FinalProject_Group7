package com.example.proj_phase2.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Venues")
data class Venue(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "venue_id") val venueId: Int = 0,
    val name: String,
    val address: String,
    val description: String,
    val coverImage: Int
)

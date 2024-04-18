package com.example.proj_phase2.data.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Events")
data class Event(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_id") val eventId: Int = 0,
    val owner: String,
    val name: String,
    val description: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val type: String,
    val coverImage: Int,
    @Embedded(prefix = "venue.") val venue: Venue,
    val planner: List<Activity>,
    val guestList: List<Guest>
)

data class Activity(
    val activityNumber: Int,
    val name: String,
    val description: String,
    val startTime: String
)

data class Guest(
    val guestNumber: Int,
    val name: String,
    val accepted: Boolean
)
package com.example.proj_phase2.data.repository

import com.example.proj_phase2.data.entities.Activity
import com.example.proj_phase2.data.entities.Event
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    fun getEventByUserStream(id: Int, user: String): Flow<Event>

    fun getAllEventsByUserStream(user: String): Flow<List<Event>>

    suspend fun insertEvent(event: Event)

    suspend fun deleteEvent(event: Event)

    suspend fun updateEvent(event: Event)
}
package com.example.proj_phase2.data.repository

import com.example.proj_phase2.data.dao.EventDao
import com.example.proj_phase2.data.entities.Event
import kotlinx.coroutines.flow.Flow

class OfflineEventRepository(private val eventDao: EventDao): EventRepository {
    override fun getEventByUserStream(id: Int, user: String): Flow<Event> = eventDao.getEventByUser(id, user)

    override fun getAllEventsByUserStream(user: String): Flow<List<Event>> = eventDao.getAllEventsByUser(user)

    override suspend fun insertEvent(event: Event) = eventDao.insert(event)

    override suspend fun deleteEvent(event: Event) = eventDao.delete(event)

    override suspend fun updateEvent(event: Event) = eventDao.update(event)
}
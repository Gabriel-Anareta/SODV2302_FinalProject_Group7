package com.example.proj_phase2.data.repository

import com.example.proj_phase2.data.entities.Venue
import kotlinx.coroutines.flow.Flow

interface VenueRepository {
    fun getVenueStream(id: Int): Flow<Venue>

    fun getAllVenuesStream(): Flow<List<Venue>>

    suspend fun insertVenue(venue: Venue)

    suspend fun deleteVenue(venue: Venue)

    suspend fun updateVenue(venue: Venue)
}
package com.example.proj_phase2.data.repository

import com.example.proj_phase2.data.dao.VenueDao
import com.example.proj_phase2.data.entities.Venue
import kotlinx.coroutines.flow.Flow

class OfflineVenueRepository(private val venueDao: VenueDao): VenueRepository {
    override fun getVenueStream(id: Int): Flow<Venue> = venueDao.getVenue(id)

    override fun getAllVenuesStream(): Flow<List<Venue>> = venueDao.getAllVenues()

    override suspend fun insertVenue(venue: Venue) = venueDao.insert(venue)

    override suspend fun deleteVenue(venue: Venue) = venueDao.delete(venue)

    override suspend fun updateVenue(venue: Venue) = venueDao.update(venue)
}
package com.example.proj_phase2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.proj_phase2.data.entities.Venue
import kotlinx.coroutines.flow.Flow

@Dao
interface VenueDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(venue: Venue)

    @Update
    suspend fun update(venue: Venue)

    @Delete
    suspend fun delete(venue: Venue)

    @Query("SELECT * FROM Venues WHERE id = :id")
    fun getVenue(id: Int): Flow<Venue>

    @Query("SELECT * FROM Venues")
    fun getAllVenues(): Flow<List<Venue>>
}
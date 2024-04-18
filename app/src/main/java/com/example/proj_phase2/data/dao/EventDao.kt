package com.example.proj_phase2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.proj_phase2.data.entities.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(event: Event)

    @Update
    suspend fun update(event: Event)

    @Delete
    suspend fun delete(event: Event)

    @Transaction
    @Query(
        "SELECT * FROM Events " +
        "WHERE event_id = :id AND owner = :user"
    )
    fun getEventByUser(id: Int, user: String): Flow<Event>

    @Transaction
    @Query(
        "SELECT * FROM Events " +
        "WHERE owner = :user " +
        "ORDER BY name ASC"
    )
    fun getAllEventsByUser(user: String): Flow<List<Event>>
}
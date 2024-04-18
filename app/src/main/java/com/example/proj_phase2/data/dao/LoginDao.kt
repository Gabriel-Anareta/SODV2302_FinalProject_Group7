package com.example.proj_phase2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.proj_phase2.data.entities.Login
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(login: Login)

    @Update
    suspend fun update(login: Login)

    @Delete
    suspend fun delete(login: Login)

    @Query("SELECT * FROM Logins")
    fun getAllLogins(): Flow<List<Login>>
}
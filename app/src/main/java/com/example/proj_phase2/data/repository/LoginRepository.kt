package com.example.proj_phase2.data.repository

import com.example.proj_phase2.data.entities.Login
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun getAllLoginsStream(): Flow<List<Login>>

    suspend fun insertLogin(login: Login)

    suspend fun deleteLogin(login: Login)

    suspend fun updateLogin(login: Login)
}
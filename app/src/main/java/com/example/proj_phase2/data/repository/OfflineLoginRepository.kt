package com.example.proj_phase2.data.repository

import com.example.proj_phase2.data.dao.LoginDao
import com.example.proj_phase2.data.entities.Login
import kotlinx.coroutines.flow.Flow

class OfflineLoginRepository(private val loginDao: LoginDao): LoginRepository {
    override fun getAllLoginsStream(): Flow<List<Login>> = loginDao.getAllLogins()

    override suspend fun insertLogin(login: Login) = loginDao.insert(login)

    override suspend fun deleteLogin(login: Login) = loginDao.delete(login)

    override suspend fun updateLogin(login: Login) = loginDao.update(login)
}
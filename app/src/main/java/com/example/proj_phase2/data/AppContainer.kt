package com.example.proj_phase2.data

import android.content.Context
import com.example.proj_phase2.data.repository.EventRepository
import com.example.proj_phase2.data.repository.LoginRepository
import com.example.proj_phase2.data.repository.OfflineEventRepository
import com.example.proj_phase2.data.repository.OfflineLoginRepository
import com.example.proj_phase2.data.repository.OfflineVenueRepository
import com.example.proj_phase2.data.repository.VenueRepository

interface AppContainer {
    val eventRepository: EventRepository

    val loginRepository: LoginRepository

    val venueRepository: VenueRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val eventRepository: EventRepository by lazy {
        OfflineEventRepository(AppDatabase.getDatabase(context).eventDao())
    }

    override val loginRepository: LoginRepository by lazy {
        OfflineLoginRepository(AppDatabase.getDatabase(context).loginDao())
    }

    override val venueRepository: VenueRepository by lazy {
        OfflineVenueRepository(AppDatabase.getDatabase(context).venueDao())
    }
}
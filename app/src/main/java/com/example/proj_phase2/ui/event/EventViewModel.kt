package com.example.proj_phase2.ui.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proj_phase2.data.entities.Event
import com.example.proj_phase2.data.entities.Login
import com.example.proj_phase2.data.repository.EventRepository
import kotlinx.coroutines.launch

class EventViewModel(private val eventRepository: EventRepository) : ViewModel() {
    fun getAllEventsList(user: String): List<Event> {
        var returnList: List<Event> = listOf()

        try {
            viewModelScope.launch {
                eventRepository.getAllEventsByUserStream(user).collect {
                    returnList = it
                }
            }
        }
        catch (e: Error) {
            return emptyList()
        }

        return returnList
    }
}
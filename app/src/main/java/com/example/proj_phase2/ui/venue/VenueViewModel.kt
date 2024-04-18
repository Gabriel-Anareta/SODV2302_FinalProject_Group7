package com.example.proj_phase2.ui.venue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proj_phase2.data.entities.Venue
import com.example.proj_phase2.data.repository.VenueRepository
import kotlinx.coroutines.launch

class VenueViewModel(private val venueRepository: VenueRepository) : ViewModel() {
    fun getAllVenuesList(): List<Venue> {
        var returnList: List<Venue> = listOf()

        try {
            viewModelScope.launch {
                venueRepository.getAllVenuesStream().collect {
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
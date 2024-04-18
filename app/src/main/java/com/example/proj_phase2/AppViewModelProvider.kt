package com.example.proj_phase2

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.proj_phase2.ui.event.EventViewModel
import com.example.proj_phase2.ui.login.LoginViewModel
import com.example.proj_phase2.ui.venue.VenueViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            LoginViewModel(MainApplication().container.loginRepository)
        }

        initializer {
            EventViewModel(MainApplication().container.eventRepository)
        }

        initializer {
            VenueViewModel(MainApplication().container.venueRepository)
        }
    }
}
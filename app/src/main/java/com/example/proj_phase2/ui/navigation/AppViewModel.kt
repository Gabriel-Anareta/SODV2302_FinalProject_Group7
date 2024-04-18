package com.example.proj_phase2.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proj_phase2.AppViewModelProvider
import com.example.proj_phase2.data.entities.Login
import com.example.proj_phase2.data.entities.Event
import com.example.proj_phase2.data.entities.Venue
import com.example.proj_phase2.ui.event.EventViewModel
import com.example.proj_phase2.ui.login.LoginViewModel
import com.example.proj_phase2.ui.venue.VenueViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AppUiState(
    val currentScreen: String? = null,
    val username: String? = null,
    val password: String? = null,
    val loginCheck: Boolean = false, // false indicates an invalid login
    val showingSideBar: Boolean = false,
    val toEvent: Event? = null,
    val eventName: String? = null,
    val eventDate: String? = null,
    val eventTime: String? = null,
    val eventType: String? = null,
    val toVenue: Venue? = null,
    val search: String? = null
)

class AppViewModel(
    loginViewModel: LoginViewModel,
    eventViewModel: EventViewModel,
    venueViewModel: VenueViewModel
) : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    val interLoginViewModel: LoginViewModel = loginViewModel
    val interEventViewModel: EventViewModel = eventViewModel
    val interVenueViewModel: VenueViewModel = venueViewModel

    val loginList: MutableList<Login> = mutableListOf()
    val eventList: MutableList<Event> = mutableListOf()
    val venueList: MutableList<Venue> = mutableListOf()

    init {
        val initialLogins: List<Login> = interLoginViewModel.getLoginList()
        for (login in initialLogins) { loginList.add(login) }
    }

    fun updateLogins() {
        val initialLogins: List<Login> = interLoginViewModel.getLoginList()

        for (login in initialLogins) {
            if (!loginList.contains(login)) {
                loginList.add(login)
            }
        }
    }

    fun updateEvents(user: String) {
        val initialEvents: List<Event> = interEventViewModel.getAllEventsList(user)

        for (event in initialEvents) {
            if (!eventList.contains(event)) {
                eventList.add(event)
            }
        }
    }

    fun updateVenues() {
        val initialVenues: List<Venue> = interVenueViewModel.getAllVenuesList()

        for (venue in initialVenues) {
            if (!venueList.contains(venue)) {
                venueList.add(venue)
            }
        }
    }

    fun ShowSideBar() {
        _uiState.update { currentState ->
            currentState.copy(showingSideBar = true)
        }
    }

    fun HideSideBar() {
        _uiState.update { currentState ->
            currentState.copy(showingSideBar = false)
        }
    }

    var usernameEntry by mutableStateOf("")
        private set

    var passwordEntry by mutableStateOf("")
        private set

    fun updateUsername(username: String) {
        usernameEntry = username
    }

    fun updatePassword(password: String) {
        passwordEntry = password
    }

    fun checkLogin() {
        updateLogins()

        val loginIterator = loginList.listIterator()
        var check = true
        var current: Login = Login(id = 0, username = "", password = "")

        while (check && loginIterator.hasNext()) {
            current = loginIterator.next()
            if (usernameEntry == current.username && passwordEntry == current.password) {
                check = false
            }
        }

        if (!check) {
            val initialEvents: List<Event> = interEventViewModel.getAllEventsList(current.username)
            for (event in initialEvents) { eventList.add(event) }

            val initialVenues: List<Venue> = interVenueViewModel.getAllVenuesList()
            for (venue in initialVenues) { venueList.add(venue) }
        }

        _uiState.update { currentState ->
            currentState.copy(loginCheck = !check)
        }
    }

    fun logout() {
        updateUsername("")
        updatePassword("")
        _uiState.update { currentState ->
            currentState.copy(loginCheck = false)
        }
    }

    fun updateToEvent(event: Event?) {
        _uiState.update { currentState ->
            currentState.copy(toEvent = event)
        }
    }


    var eventNameEntry by mutableStateOf("")
        private set

    var eventDateEntry by mutableStateOf("")
        private set

    var eventTimeEntry by mutableStateOf("")
        private set

    var eventTypeEntry by mutableStateOf("")
        private set

    fun updateEventName(name: String) {
        eventNameEntry = name
    }

    fun updateEventDate(date: String) {
        eventDateEntry = date
    }

    fun updateEventTime(time: String) {
        eventTimeEntry = time
    }

    fun updateEventType(type: String) {
        eventTypeEntry = type
    }

    fun updateToVenue(venue: Venue?) {
        _uiState.update { currentState ->
            currentState.copy(toVenue = venue)
        }
    }


    var searchEntry by mutableStateOf("")
        private set

    var searchLength by mutableIntStateOf(0)
        private set

    var searchList: MutableList<Venue> = mutableListOf()
        private set

    fun updateSearch(search: String) {
        searchEntry = search
        searchLength = searchEntry.length

        searchList.clear()

        for (venue in venueList) {
            if (venue.name.take(searchLength).lowercase() == searchEntry.lowercase()) {
                searchList.add(venue)
            }
        }
    }
}
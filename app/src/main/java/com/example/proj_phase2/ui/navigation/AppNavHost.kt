package com.example.proj_phase2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proj_phase2.AppViewModelProvider
import com.example.proj_phase2.data.entities.Venue
import com.example.proj_phase2.ui.event.AllEventsDestination
import com.example.proj_phase2.ui.event.AllEventsScreen
import com.example.proj_phase2.ui.event.CreateEventDestination
import com.example.proj_phase2.ui.event.CreateEventScreen
import com.example.proj_phase2.ui.event.EventDestination
import com.example.proj_phase2.ui.event.EventScreen
import com.example.proj_phase2.ui.home.HomeDestination
import com.example.proj_phase2.ui.home.HomeScreen
import com.example.proj_phase2.ui.login.LoginDestination
import com.example.proj_phase2.ui.login.LoginScreen
import com.example.proj_phase2.ui.search.SearchDestination
import com.example.proj_phase2.ui.search.SearchScreen
import com.example.proj_phase2.ui.venue.VenueDestination
import com.example.proj_phase2.ui.venue.VenueScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: AppViewModel = AppViewModel(
        loginViewModel = viewModel(factory = AppViewModelProvider.Factory),
        eventViewModel = viewModel(factory = AppViewModelProvider.Factory),
        venueViewModel = viewModel(factory = AppViewModelProvider.Factory)
    )
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController, startDestination = LoginDestination.route, modifier = modifier
    ) {
        composable(route = LoginDestination.route) {
            LoginScreen(
                username = viewModel.usernameEntry,
                password = viewModel.passwordEntry,
                onUsernameChange = { viewModel.updateUsername(it) },
                onPasswordChange = { viewModel.updatePassword(it) },
                onClick = { viewModel.checkLogin() }
            )

            if (uiState.loginCheck) {
                navController.navigate(HomeDestination.route)
            }
        }

        composable(route = HomeDestination.route) {
            HomeScreen(
                eventList = viewModel.eventList,
                onSideBarClick = { viewModel.ShowSideBar() },
                onSearchClick = { navController.navigate(SearchDestination.route) },
                onNotificationsClick = { },
                onCreateEventClick = { navController.navigate(CreateEventDestination.route) },
                onEventClick = { viewModel.updateToEvent(it) }
            )

            if (uiState.showingSideBar) {
                NavSideBar(
                    onCloseClick = { viewModel.HideSideBar() },
                    onHomeClick = { viewModel.HideSideBar() },
                    onYourEventsClick = {
                        viewModel.HideSideBar()
                        navController.navigate(EventDestination.route) },
                    onCreateEventClick = {
                        viewModel.HideSideBar()
                        navController.navigate(CreateEventDestination.route) },
                    onInvitationsClick = { },
                    onSearchClick = {
                        viewModel.HideSideBar()
                        navController.navigate(SearchDestination.route) },
                    onNotificationsClick = { },
                    onAccountClick = { },
                    onLogoutClick = {
                        viewModel.HideSideBar()
                        viewModel.logout()
                        navController.navigate(LoginDestination.route) }
                )
            }

            if (uiState.toEvent != null) {
                viewModel.HideSideBar()
                navController.navigate(EventDestination.route)
            }
        }

        composable(route = AllEventsDestination.route) {
            AllEventsScreen(
                eventList = viewModel.eventList,
                onSideBarClick = { viewModel.ShowSideBar() },
                onEventClick = { viewModel.updateToEvent(it) }
            )

            if (uiState.showingSideBar) {
                NavSideBar(
                    onCloseClick = { viewModel.HideSideBar() },
                    onHomeClick = {
                        viewModel.HideSideBar()
                        navController.navigate(HomeDestination.route) },
                    onYourEventsClick = { viewModel.HideSideBar() },
                    onCreateEventClick = {
                        viewModel.HideSideBar()
                        navController.navigate(CreateEventDestination.route) },
                    onInvitationsClick = { },
                    onSearchClick = {
                        viewModel.HideSideBar()
                        navController.navigate(SearchDestination.route) },
                    onNotificationsClick = { },
                    onAccountClick = { },
                    onLogoutClick = {
                        viewModel.HideSideBar()
                        viewModel.logout()
                        navController.navigate(LoginDestination.route) }
                )
            }

            if (uiState.toEvent != null) {
                viewModel.HideSideBar()
                navController.navigate(EventDestination.route)
            }
        }

        composable(route = CreateEventDestination.route) {
            CreateEventScreen(
                venueList = viewModel.venueList,
                eventName = viewModel.eventNameEntry,
                eventDate = viewModel.eventDateEntry,
                eventTime = viewModel.eventTimeEntry,
                eventType = viewModel.eventTypeEntry,
                onNameChange = { viewModel.updateEventName(it) },
                onDateChange = { viewModel.updateEventDate(it) },
                onTimeChange = { viewModel.updateEventTime(it) },
                onTypeChange = { viewModel.updateEventType(it) },
                onVenueClick = { viewModel.updateToVenue(it) },
                onSideBarClick = { viewModel.ShowSideBar() }
            )

            if (uiState.showingSideBar) {
                NavSideBar(
                    onCloseClick = { viewModel.HideSideBar() },
                    onHomeClick = {
                        viewModel.HideSideBar()
                        navController.navigate(HomeDestination.route) },
                    onYourEventsClick = {
                        viewModel.HideSideBar()
                        navController.navigate(EventDestination.route) },
                    onCreateEventClick = { viewModel.HideSideBar() },
                    onInvitationsClick = { },
                    onSearchClick = {
                        viewModel.HideSideBar()
                        navController.navigate(SearchDestination.route) },
                    onNotificationsClick = { },
                    onAccountClick = { },
                    onLogoutClick = {
                        viewModel.HideSideBar()
                        viewModel.logout()
                        navController.navigate(LoginDestination.route) }
                )
            }

            if (uiState.toVenue != null) {
                viewModel.HideSideBar()
                navController.navigate(VenueDestination.route)
            }
        }

        composable(route = EventDestination.route) {
            uiState.toEvent?.let { event ->
                EventScreen(
                    event = event,
                    onSideBarClick = { viewModel.ShowSideBar() },
                )
            }

            if (uiState.showingSideBar) {
                NavSideBar(
                    onCloseClick = { viewModel.HideSideBar() },
                    onHomeClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToEvent(null)
                        navController.navigate(HomeDestination.route) },
                    onYourEventsClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToEvent(null)
                        navController.navigate(EventDestination.route) },
                    onCreateEventClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToEvent(null)
                        navController.navigate(CreateEventDestination.route) },
                    onInvitationsClick = { },
                    onSearchClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToEvent(null)
                        navController.navigate(SearchDestination.route) },
                    onNotificationsClick = { },
                    onAccountClick = { },
                    onLogoutClick = {
                        viewModel.HideSideBar()
                        viewModel.logout()
                        viewModel.updateToEvent(null)
                        navController.navigate(LoginDestination.route) }
                )
            }
        }

        composable(route = VenueDestination.route) {
            uiState.toVenue?.let { venue ->
                VenueScreen(
                    venue = venue,
                    onSideBarClick = { viewModel.ShowSideBar() },
                )
            }

            if (uiState.showingSideBar) {
                NavSideBar(
                    onCloseClick = { viewModel.HideSideBar() },
                    onHomeClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToVenue(null)
                        navController.navigate(HomeDestination.route) },
                    onYourEventsClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToVenue(null)
                        navController.navigate(EventDestination.route) },
                    onCreateEventClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToVenue(null)
                        navController.navigate(CreateEventDestination.route) },
                    onInvitationsClick = { },
                    onSearchClick = {
                        viewModel.HideSideBar()
                        viewModel.updateToVenue(null)
                        navController.navigate(SearchDestination.route) },
                    onNotificationsClick = { },
                    onAccountClick = { },
                    onLogoutClick = {
                        viewModel.HideSideBar()
                        viewModel.logout()
                        viewModel.updateToVenue(null)
                        navController.navigate(LoginDestination.route) }
                )
            }
        }

        composable(route = SearchDestination.route) {
            SearchScreen(
                search = viewModel.searchEntry,
                onSearchChange = { viewModel.updateSearch(it) },
                venueList = viewModel.venueList,
                searchList = viewModel.searchList,
                onSideBarClick = { viewModel.ShowSideBar() },
                onVenueClick = { viewModel.updateToVenue(it) }
            )

            if (uiState.showingSideBar) {
                NavSideBar(
                    onCloseClick = { viewModel.HideSideBar() },
                    onHomeClick = {
                        viewModel.HideSideBar()
                        navController.navigate(HomeDestination.route) },
                    onYourEventsClick = {
                        viewModel.HideSideBar()
                        navController.navigate(EventDestination.route) },
                    onCreateEventClick = {
                        viewModel.HideSideBar()
                        navController.navigate(CreateEventDestination.route) },
                    onInvitationsClick = { },
                    onSearchClick = { viewModel.HideSideBar() },
                    onNotificationsClick = { },
                    onAccountClick = { },
                    onLogoutClick = {
                        viewModel.HideSideBar()
                        viewModel.logout()
                        navController.navigate(LoginDestination.route) }
                )
            }

            if (uiState.toVenue != null) {
                viewModel.HideSideBar()
                navController.navigate(VenueDestination.route)
            }
        }
    }
}
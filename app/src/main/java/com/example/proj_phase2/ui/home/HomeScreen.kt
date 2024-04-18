package com.example.proj_phase2.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proj_phase2.R
import com.example.proj_phase2.data.entities.Event
import com.example.proj_phase2.ui.event.BaseEventDisplay
import com.example.proj_phase2.ui.navigation.NavDestination

object HomeDestination : NavDestination {
    override val route = "Home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeScreen(
    eventList: List<Event>,
    onSideBarClick: () -> Unit,
    onSearchClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onCreateEventClick: () -> Unit,
    onEventClick: (Event) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { HomeTopBar(
            onSideBarClick = onSideBarClick,
            onSearchClick = onSearchClick,
            onNotificationClick = onNotificationsClick
        ) },
        bottomBar = {
            HomeBottomBar(onCreateEventClick = onCreateEventClick)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.Padding_Medium), 0.dp)
            ) {
                item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium))) }

                item {
                    Text(
                        text = stringResource(R.string.Home_Subtitle_1),
                        style = MaterialTheme.typography.displayLarge
                    )
                }

                item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium))) }

                item {
                    BaseEventDisplay(
                        event = eventList[0],
                        onEventClick = { onEventClick(eventList[0]) }
                    )
                }

                item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Large))) }

                item {
                    Text(
                        text = stringResource(R.string.Home_Subtitle_2),
                        style = MaterialTheme.typography.displayLarge
                    )
                }

                item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium))) }

                item {
                    BaseEventDisplay(
                        event = eventList[0],
                        onEventClick = onEventClick
                    )
                }

                if (eventList.size > 1) {
                    item {
                        BaseEventDisplay(
                            event = eventList[1],
                            onEventClick = onEventClick
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onSideBarClick: () -> Unit,
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {  },
        navigationIcon = {
            IconButton(onClick = onSideBarClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.Expand_Menu_Desc)
                )
            }
        },
        actions = {
            Row() {
                IconButton(onClick = onSearchClick) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.Go_Search_Desc)
                    )
                }

                IconButton(onClick = onNotificationClick) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = stringResource(R.string.Go_Notifications_Desc)
                    )
                }
            }
        }
    )
}

@Composable
fun HomeBottomBar(
    onCreateEventClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        actions = {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                FloatingActionButton(onClick = onCreateEventClick) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Create Event"
                    )
                }

                Spacer(modifier = Modifier.padding(end = 16.dp))
            }
        },
        containerColor = Color.Transparent
    )
}

//@Preview
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}

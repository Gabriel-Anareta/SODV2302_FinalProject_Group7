package com.example.proj_phase2.ui.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.proj_phase2.R
import com.example.proj_phase2.ui.event.BaseEventDisplay
import com.example.proj_phase2.data.entities.Event
import com.example.proj_phase2.ui.navigation.NavDestination

object AllEventsDestination : NavDestination {
    override val route = "AllEvents"
    override val titleRes = R.string.app_name
}

@Composable
fun AllEventsScreen(
    eventList: List<Event>,
    onSideBarClick: () -> Unit,
    onEventClick: (Event) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { AllEventsTopBar(
            onSideBarClick = onSideBarClick
        ) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Padding_Medium)),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.Padding_Medium))
            ) {
                items(eventList) {
                    var event = it
                    BaseEventDisplay(
                        event = event,
                        onEventClick = { onEventClick(event) }
                    )
                }
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllEventsTopBar(
    onSideBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.AllEvents_Title),
                style = MaterialTheme.typography.headlineMedium
            )
        },
        navigationIcon = {
            IconButton(onClick = onSideBarClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.Expand_Menu_Desc)
                )
            }
        }
    )
}
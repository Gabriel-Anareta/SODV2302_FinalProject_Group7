package com.example.proj_phase2.ui.event

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proj_phase2.R
import com.example.proj_phase2.data.entities.Activity
import com.example.proj_phase2.data.entities.Event
import com.example.proj_phase2.ui.navigation.NavDestination

object EventDestination : NavDestination {
    override val route = "Event_Details"
    override val titleRes = R.string.app_name
}

@Composable
fun EventScreen(
    event: Event,
    onSideBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { EventTopBar(
            event = event,
            onSideBarClick = onSideBarClick
        ) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.Padding_Medium))
            ) {
                Image(
                    painter = painterResource(id = event.coverImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium)))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = stringResource(R.string.Event_Subtite_1),
                            style = MaterialTheme.typography.displayMedium
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium)))

                        Text(
                            text = event.date
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Small)))

                        Text(
                            text = event.description
                        )
                    }

                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.Padding_Medium)))

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        GuestDisplay(event)
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Large)))

                ActivityDisplay(activityList = event.planner)
            }
        }
    }
}

@Composable
fun GuestDisplay(event: Event) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Padding_Small))
    ) {
        item {
            Text(
                text = stringResource(R.string.Event_Subtitle_2),
                style = MaterialTheme.typography.displayMedium
            )
        }

        item { Spacer(modifier = Modifier.height(0.dp)) }

        items(event.guestList) {
            Text(
                text = it.name + " - " +
                        if (it.accepted != null) {
                            if (it.accepted) {
                                "is going"
                            } else {
                                "is not going"
                            }
                        } else {
                            "has not responded"
                        }
            )
        }
    }
}

@Composable
fun ActivityDisplay(activityList: List<Activity>) {
    Column {
        Text(
            text = stringResource(R.string.Event_Subtitle_3),
            style = MaterialTheme.typography.displayMedium
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium)))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Padding_Medium))
        ) {
            items(activityList) {
                ActivityCard(activity = it)
            }
        }
    }

}

@Composable
fun ActivityCard(activity: Activity) {
    Column {
        Text(
            text = activity.name,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Small)))

        Text(
            text = activity.startTime
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Small)))

        Text(
            text = activity.description
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventTopBar(
    event: Event,
    onSideBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
                Text(
                    text = event.name,
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
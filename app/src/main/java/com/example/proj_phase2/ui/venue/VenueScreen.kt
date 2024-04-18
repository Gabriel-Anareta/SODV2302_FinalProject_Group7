package com.example.proj_phase2.ui.venue

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
import com.example.proj_phase2.data.entities.Venue
import com.example.proj_phase2.ui.navigation.NavDestination

object VenueDestination : NavDestination {
    override val route = "Venue_Details"
    override val titleRes = R.string.app_name
}

@Composable
fun VenueScreen(
    venue: Venue,
    onSideBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { VenueTopBar(
            venue = venue,
            onSideBarClick = onSideBarClick
        ) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.Padding_Medium))
            ) {
                Image(
                    painter = painterResource(id = venue.coverImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium)))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.Venue_Subtitle_1)
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium)))

                    Text(
                        text = venue.address
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Small)))

                    Text(
                        text = venue.description
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VenueTopBar(
    venue: Venue,
    onSideBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = venue.name,
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

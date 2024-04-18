package com.example.proj_phase2.ui.event

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.proj_phase2.R
import com.example.proj_phase2.data.entities.Venue
import com.example.proj_phase2.ui.navigation.NavDestination
import com.example.proj_phase2.ui.venue.VenueDisplay

object CreateEventDestination : NavDestination {
    override val route = "CreateEvent"
    override val titleRes = R.string.app_name
}

@Composable
fun CreateEventScreen(
    venueList: List<Venue>,
    eventName: String,
    eventDate: String,
    eventTime: String,
    eventType: String,
    onNameChange: (String) -> Unit,
    onDateChange: (String) -> Unit,
    onTimeChange: (String) -> Unit,
    onTypeChange: (String) -> Unit,
    onVenueClick: (Venue) -> Unit,
    onSideBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { CreateEventTopBar(
            onSideBarClick = onSideBarClick
        ) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.Padding_Medium))
            ) {
                Row() {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        val focusManager = LocalFocusManager.current

                        TextField(
                            value = eventName,
                            onValueChange = onNameChange,
                            placeholder = { Text(text = stringResource(R.string.CreateEvent_NameField)) },
                            label = { Text(text = stringResource(R.string.CreateEvent_NameField)) },
                            maxLines = 1,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Down) }
                            ),
                            modifier = Modifier
                                .background(color = Color.Transparent)
                                .padding(dimensionResource(id = R.dimen.Padding_Small))
                        )

                        TextField(
                            value = eventDate,
                            onValueChange = onDateChange,
                            placeholder = { Text(text = stringResource(R.string.CreateEvent_DateField)) },
                            label = { Text(text = stringResource(R.string.CreateEvent_DateField)) },
                            maxLines = 1,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Down) }
                            ),
                            modifier = Modifier
                                .background(color = Color.Transparent)
                                .padding(dimensionResource(id = R.dimen.Padding_Small))
                        )

                        TextField(
                            value = eventTime,
                            onValueChange = onTimeChange,
                            placeholder = { Text(text = stringResource(R.string.CreateEvent_TimeField)) },
                            label = { Text(text = stringResource(R.string.CreateEvent_TimeField)) },
                            maxLines = 1,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Down) }
                            ),
                            modifier = Modifier
                                .background(color = Color.Transparent)
                                .padding(dimensionResource(id = R.dimen.Padding_Small))
                        )

                        TextField(
                            value = eventType,
                            onValueChange = onTypeChange,
                            placeholder = { Text(text = stringResource(R.string.CreateEvent_TypeField)) },
                            label = { Text(text = stringResource(R.string.CreateEvent_TypeField)) },
                            maxLines = 1,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { focusManager.clearFocus() }
                            ),
                            modifier = Modifier
                                .background(color = Color.Transparent)
                                .padding(dimensionResource(id = R.dimen.Padding_Small))
                        )
                    } // End of Column

                    TextButton(
                        onClick = { },
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.LightGray
                        ),
                        modifier = Modifier
                            .padding(dimensionResource(id = R.dimen.Padding_Small))
                            .weight(1f)
                            .aspectRatio(1f)
                    ) {
                        Text(
                            text = stringResource(R.string.CreateEvent_CoverImageField),
                            modifier = Modifier
                        )
                    }
                } // End of Row

                Column(
                    modifier = Modifier.padding(
                        dimensionResource(id = R.dimen.Padding_Small),
                        dimensionResource(id = R.dimen.Padding_Large)
                    )
                ) {
                    Row {
                        Text(
                            text = stringResource(R.string.CreateEvent_VenueField)
                        )

                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.Padding_Small)))

                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.Padding_Medium)))

                    LazyColumn() {
                        items(venueList) {
                            var venue = it
                            VenueDisplay(
                                venue = it,
                                onVenueClick = { onVenueClick(venue) }
                            )
                        }
                    }
                }
            } // End of column
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEventTopBar(
    onSideBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.CreateEvent_Title),
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
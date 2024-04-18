package com.example.proj_phase2.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proj_phase2.R

@Composable
fun NavSideBar(
    onCloseClick: () -> Unit,
    onHomeClick: () -> Unit,
    onYourEventsClick: () -> Unit,
    onCreateEventClick: () -> Unit,
    onInvitationsClick: () -> Unit,
    onSearchClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onAccountClick: () -> Unit,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .background(color = Color(0x55000000))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .background(color = Color(0xFFFFFFFF))
                .fillMaxHeight()
        ) {
            IconButton(
                onClick = onCloseClick,
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.Padding_Small),
                    top = dimensionResource(id = R.dimen.Padding_Small),
                    end = 0.dp,
                    bottom = 0.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.Minimize_Menu_Desc)
                )
            }

            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.Padding_Medium))
            ) {
                Divider(color = Color.Black)

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(0.dp, dimensionResource(id = R.dimen.Padding_Small))
                ) {
                    CustomButton(
                        onClick = onHomeClick,
                        text = R.string.Side_Button_Home
                    )

                    CustomButton(
                        onClick = onYourEventsClick,
                        text = R.string.Side_Button_AllEvents
                    )

                    CustomButton(
                        onClick = onCreateEventClick,
                        text = R.string.Side_Button_CreateEvent
                    )

                    CustomButton(
                        onClick = onInvitationsClick,
                        text = R.string.Side_Button_Invitations
                    )

                    CustomButton(
                        onClick = onSearchClick,
                        text = R.string.Side_Button_Search
                    )
                }

                Divider(color = Color.Black)

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(0.dp, dimensionResource(id = R.dimen.Padding_Small))
                ) {
                    CustomButton(
                        onClick = onNotificationsClick,
                        text = R.string.Side_Button_Notifications
                    )

                    CustomButton(
                        onClick = onAccountClick,
                        text = R.string.Side_Button_Account
                    )

                    CustomButton(
                        onClick = onLogoutClick,
                        text = R.string.Side_Button_Logout
                    )
                }
            }
        }

        Column(modifier = Modifier.weight(1f)) {}
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.Padding_Small))
    ) {
        Text(
            text = stringResource(id = text),
            modifier = Modifier
        )
    }
}

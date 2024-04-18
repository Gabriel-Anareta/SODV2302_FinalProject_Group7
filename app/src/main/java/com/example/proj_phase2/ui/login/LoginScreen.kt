package com.example.proj_phase2.ui.login

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.proj_phase2.R
import com.example.proj_phase2.ui.navigation.NavDestination

object LoginDestination : NavDestination {
    override val route = "Login"
    override val titleRes = R.string.app_name
}

@Composable
fun LoginScreen(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(
                dimensionResource(id = R.dimen.Padding_Large),
                dimensionResource(id = R.dimen.Padding_Medium)
            )
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.Login_Title),
            style = MaterialTheme.typography.displayLarge
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            val focusManager = LocalFocusManager.current

            TextField(
                value = username,
                onValueChange = onUsernameChange,
                placeholder = { Text(
                    text = stringResource(R.string.Username_Input_Label),
                    style = MaterialTheme.typography.labelMedium
                ) },
                label = { Text(
                    text = stringResource(R.string.Username_Input_Label),
                    style = MaterialTheme.typography.labelMedium
                ) },
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
                value = password,
                onValueChange = onPasswordChange,
                placeholder = { Text(
                    text = stringResource(R.string.Password_Input_Label),
                    style = MaterialTheme.typography.labelMedium
                ) },
                label = { Text(
                    text = stringResource(R.string.Password_Input_Label),
                    style = MaterialTheme.typography.labelMedium
                ) },
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                        onClick()
                    }
                ),
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .padding(dimensionResource(id = R.dimen.Padding_Small))
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            OutlinedButton(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.Padding_Small))
            ) {
                Text(
                    text = stringResource(R.string.Login_Button),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .height(dimensionResource(id = R.dimen.Padding_Large))
                )
            }

            OutlinedButton(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.Padding_Small))
            ) {
                Text(
                    text = stringResource(R.string.SignUp_Button),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .height(dimensionResource(id = R.dimen.Padding_Large))
                )
            }
        }
    }
}

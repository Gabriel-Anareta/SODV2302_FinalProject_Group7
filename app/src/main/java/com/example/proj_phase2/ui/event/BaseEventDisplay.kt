package com.example.proj_phase2.ui.event

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.proj_phase2.R
import com.example.proj_phase2.data.entities.Event

@Composable
fun BaseEventDisplay(
    event: Event,
    onEventClick: (Event) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.Base_Cover_Image_Size))
                .height(dimensionResource(id = R.dimen.Base_Cover_Image_Size))
        ) {
            Image(
                painter = painterResource(id = event.coverImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
            )
        }

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.Padding_Medium)))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = event.name,
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.Padding_Small)))

            Text(
                text = event.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.Padding_Medium)))

        IconButton(
            onClick = { onEventClick(event) },
            modifier = Modifier.width(dimensionResource(id = R.dimen.Padding_Large))
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = stringResource(R.string.EventDisplay_GoTo)
            )
        }
    }
}
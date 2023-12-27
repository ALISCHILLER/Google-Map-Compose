package com.msa.googlemapcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ComposeMapCenterPointMapMarker() {
    val markerPosition = LatLng(35.8439, 50.9715)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(markerPosition, 8f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {
            },
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_share_location_24),
                contentDescription = "marker",
            )
        }
        Text(text = "Is camera moving: ${cameraPositionState.isMoving}" +
                "\n Latitude and Longitude: ${cameraPositionState.position.target.latitude} " +
                "and ${cameraPositionState.position.target.longitude}",
            textAlign = TextAlign.Center,
            color = Color.Red
        )
    }
}
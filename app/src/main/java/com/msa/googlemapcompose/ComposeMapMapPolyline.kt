package com.msa.googlemapcompose

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ComposeMapMapPolyline() {
    val tehran = LatLng(35.7219, 51.3347)
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(tehran, 5f)
    }
    Box(Modifier.fillMaxSize()) {
        GoogleMap(cameraPositionState = cameraPositionState){

            MapMarker(
                context = LocalContext.current,
                positon = tehran,
                title = "Tehran",
                iconResource = R.drawable.baseline_share_location_24
            )

            Polyline(
                points = listOf(
                    LatLng(35.7219, 51.3347),
                    LatLng(35.7219, 51.3447),
                    LatLng(35.7219, 51.3547),
                    LatLng(35.7219, 51.3647),
                    LatLng(35.7219, 51.3747),
                    LatLng(35.7219, 51.3847),

                )
                ,color = Color.Magenta
            )
        }
    }
}



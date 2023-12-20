package com.msa.googlemapcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.msa.googlemapcompose.ui.theme.GoogleMapComposeTheme

@Composable
fun ComposeMapDemo() {
    val iran =LatLng(32.00,53.00)
    val tehran =LatLng(35.7219,51.3347)
    val cameraPostionState= rememberCameraPositionState{
        position= CameraPosition.fromLatLngZoom(iran,5f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
    ){
        Marker(
            state = rememberMarkerState(position = iran),
            draggable = true,
            title = "Iran",
            snippet = "Marker in iran",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
        )

        MapMarker(
            context = LocalContext.current,
            positon = tehran,
            title = "Tehran",
            iconResource = R.drawable.baseline_share_location_24
        )
    }
}
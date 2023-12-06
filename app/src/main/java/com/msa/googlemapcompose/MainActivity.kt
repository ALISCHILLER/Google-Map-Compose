package com.msa.googlemapcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.msa.googlemapcompose.ui.theme.GoogleMapComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleMapComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // ComposeMapDemo()
                    ComposeMypPropertiesDemo()
                }
            }
        }
    }
}


@Composable
fun ComposeMapDemo() {
    val singapore =LatLng(32.00,53.00)
    val cameraPostionState= rememberCameraPositionState{
        position= CameraPosition.fromLatLngZoom(singapore,30f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPostionState
    ){
        Marker(
            state = rememberMarkerState(position = singapore),
            draggable = true,
            title = "Iran",
            snippet = "Marker in iran",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
        )
    }
}

@Composable
fun ComposeMypPropertiesDemo() {
    var uiSettings by remember {
        mutableStateOf(MapUiSettings())
    }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }

    Box(Modifier.fillMaxSize()){

        GoogleMap(
            modifier = Modifier.matchParentSize(),
            properties = properties,
            uiSettings = uiSettings
        )
        Switch(
            checked = uiSettings.zoomControlsEnabled,
            onCheckedChange ={
                uiSettings = uiSettings.copy(zoomControlsEnabled = it)
            }
        )
    }


}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoogleMapComposeTheme {
        ComposeMapDemo()
    }
}
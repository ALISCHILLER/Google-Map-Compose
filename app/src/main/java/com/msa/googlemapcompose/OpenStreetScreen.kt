package com.msa.googlemapcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.msa.googlemapcompose.ui.theme.GoogleMapComposeTheme

@Composable
fun OsmdroidMapView() {
    val context = LocalContext.current


}

@Preview
@Composable
fun OsmdroidMapViewPreview() {

    GoogleMapComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
          
        ) {
            OsmdroidMapView()
        }
    }
}

//    MapAppTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//
//            OsmdroidMapView()
//        }
//    }
//    val ctx = applicationContext
//    Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
//    Configuration.getInstance().userAgentValue = "MapApp"

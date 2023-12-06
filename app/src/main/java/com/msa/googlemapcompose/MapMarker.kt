package com.msa.googlemapcompose

import android.content.Context
import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun MapMarker(
    context: Context,
    positon:LatLng,
    title:String
) {

    Marker(
        state = MarkerState(position=positon),
        title = title,
    )
}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId:Int
):BitmapDescriptor?{



    return null
}
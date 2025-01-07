package com.missgem.hwhnhl.feature.test


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TestRoute() {
    testScreen()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun testScreen() {
    Scaffold (
//        topBar = {}
    ) {
        Column {
            Text("qwe")
            Text("test")

        }
    }

}


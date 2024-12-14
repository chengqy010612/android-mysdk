package com.example.clientapp.feature.home


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.provider.FontsContractCompat.Columns

@Composable
fun HomeRoute() {
    homeScreen()
}


@Composable
fun homeScreen() {
    Column {
        Text("home")
    }
}
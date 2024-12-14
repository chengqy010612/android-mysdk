package com.example.clientapp.feature.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clientapp.R

@Composable
fun SplashRoute() {
    Column {
        SplashRouteScreen()
    }
}

@Composable
fun SplashRouteScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)

    ) {
        //logo
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = null,
            modifier = Modifier
                .padding(60.dp)
                .align(Alignment.TopCenter)
                .clip(CircleShape)
        )
        Text(
            text = "网易云应约哈哈哈哈哈哈",
            modifier = Modifier
                .padding(bottom = 70.dp)
                .align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 20.sp
        )
        Text(
            text = stringResource(R.string.copyright),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashRoutePreview() {
    SplashRoute()
}


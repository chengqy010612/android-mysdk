package com.missgem.hwhnhl.feature.test


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.missgem.hwhnhl.components.VideoView
import com.tencent.rtmp.TXVodPlayer

@Composable
fun TestRoute() {
    testScreen()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun testScreen() {
    val mVodPlayer = TXVodPlayer(LocalContext.current)

    Scaffold (
//        topBar = {}
    ) {
        Column {
            Text("qwe")
            Text("test")
            VideoView(mVodPlayer)
        }
    }

}


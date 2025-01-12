package com.missgem.hwhnhl.feature.home


import android.content.Intent
import android.widget.VideoView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
//import com.missgem.hwhnhl.activity.TestActivity
import com.missgem.hwhnhl.components.VideoView
import com.tencent.rtmp.TXVodPlayer


@Composable
fun HomeRoute() {
    homeScreen()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen() {
//    val navController = LocalNavController.current
    val context = LocalContext.current
//    val mediaItem = remember { MediaSource.Factory(context).createMediaSource(Uri.parse("http://example.com/video.mp4")) }
    val mVodPlayer = TXVodPlayer(context)

    LaunchedEffect(mVodPlayer) {
        val url = "https://www.w3schools.com/html/movie.mp4";
        mVodPlayer.startVodPlay(url);
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(16.dp)
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("消息(1)")
                    },
                    actions = {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = innerPadding) // padding applied here
            ) {
//                Text(
//                    modifier = Modifier.padding(8.dp),
//                    text =
//                    """
//                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
//
//                    It also contains some basic inner content, such as this text.
//
//                """.trimIndent(),
//                )
//                    Button(onClick = {
//
//                    }) {
//                        Text(text =  "测试")
//                    }

//                VideoView(mVodPlayer)


            }
        }


    }




//    var state by remember { mutableStateOf(0) }
//    val titles = listOf("Tab 1", "Tab 2", "Tab 3 ")
//        TabRow(selectedTabIndex = state) {
//            titles.forEachIndexed { index, title ->
//                Tab(
//                    selected = state == index,
//                    onClick = { state = index },
//                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
//                )
//            }
//        }
}


@Preview(showBackground = true)
@Composable
fun homeScreenPreview() {
    homeScreen()
}
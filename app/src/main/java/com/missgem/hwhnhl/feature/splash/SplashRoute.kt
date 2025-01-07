package com.missgem.hwhnhl.feature.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clientapp.R
import kotlin.reflect.KFunction0

@Composable
fun SplashRoute(toMain: () -> Unit = {}, viewModel: SplashViewModel = viewModel()) {
    val timeCount by viewModel.timeCount.collectAsStateWithLifecycle()
    val navToMain by viewModel.navTopMain.collectAsState()

    splashScreen(toMain, timeCount,skipAd = viewModel::skipAd)

    if(navToMain){
        LaunchedEffect(key1 = navToMain) {
            toMain()
        }
    }

//    var count by remember {
//        mutableIntStateOf(0)
//    }
////   watch 监听
//    LaunchedEffect(count) {}
}

@Composable
fun splashScreen(toMain: () -> Unit = {}, timeCount: Long = 0, skipAd: KFunction0<Unit>) {
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
                .clickable {
                    toMain()
                }
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
        //倒计时
        Text(
            text = "倒计时:$timeCount",
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 100.dp, top = 40.dp)
        )
        Text(
            text = "关闭",
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 50.dp, top = 40.dp)
                .clickable { skipAd() }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun SplashRoutePreview() {
    SplashRoute()
}


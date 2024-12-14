package com.example.clientapp.feature.main


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clientapp.components.NavBar
import com.example.clientapp.feature.home.HomeRoute
import com.example.clientapp.feature.my.MyRoute
import com.example.clientapp.feature.test.TestRoute

@Composable
fun MainRoute(finishPage: () -> Unit) {
    MainScreen(finishPage = finishPage)
}


@Composable
fun MainScreen(finishPage: () -> Unit) {
    val pagerState = rememberPagerState { 3 }
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
        when (page) {
            0 -> HomeRoute()
            1 -> TestRoute()
//            2 -> MessageRoute()
            2 -> MyRoute()
        }
    }
    Button(onClick = { finishPage() }) {
        Text("退出")
    }

    NavBar()

}

@Preview(showBackground = true)
@Composable
fun MianRoutePreview() {

}


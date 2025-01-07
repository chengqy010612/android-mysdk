package com.missgem.hwhnhl.feature.main


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.missgem.hwhnhl.components.NavBar
import com.missgem.hwhnhl.feature.home.HomeRoute
import com.missgem.hwhnhl.feature.my.MyRoute
import com.missgem.hwhnhl.feature.test.TestRoute
import kotlinx.coroutines.launch

@Composable
fun MainRoute(finishPage: () -> Unit) {
    MainScreen(finishPage = finishPage)
}


@Composable
fun MainScreen(finishPage: () -> Unit) {

    val scope = rememberCoroutineScope()
    //   选中项
    var selectedItem by remember { mutableIntStateOf(0) }

    Column {
        val pagerState = rememberPagerState { 3 }
        HorizontalPager(state = pagerState, modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .weight(1f)) { page ->
            when (page) {
                0 -> HomeRoute()
                1 -> TestRoute()
//            2 -> MessageRoute()
                2 -> MyRoute()
            }
        }
//        Button(onClick = { finishPage() }) {
//            Text("退出")
//        }
        NavBar(selectedItem, pagerState, onNavSelect = { index ->
            selectedItem = index
            scope.launch {
                pagerState.animateScrollToPage(index)
            }
        })
    }

}

@Preview(showBackground = true)
@Composable
fun MianRoutePreview() {

}


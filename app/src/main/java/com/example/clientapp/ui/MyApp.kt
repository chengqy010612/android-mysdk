package com.example.clientapp.ui


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.clientapp.feature.main.MAIN_ROUTE
import com.example.clientapp.feature.main.mainScreen
import com.example.clientapp.feature.main.navigateToMain

import com.example.clientapp.feature.splash.SPLASH_ROUTE
import com.example.clientapp.feature.splash.splashScreen

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MAIN_ROUTE) {
        splashScreen(
            toMain = {
                navController.navigateToMain()
            }
        )
        mainScreen(finishPage = { navController.popBackStack() })
    }
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
//    MyApp()
}


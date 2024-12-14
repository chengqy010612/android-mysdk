package com.example.clientapp.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.clientapp.feature.splash.SPLASH_ROUTE

const val MAIN_ROUTE ="main"

fun NavController.navigateToMain() {

    navigate(MAIN_ROUTE){
//    单个     launchSingleTop
        //   repalce
        popUpTo(SPLASH_ROUTE){
            inclusive = true
        }
    }
}

fun NavGraphBuilder.mainScreen(finishPage: () -> Unit) {
    composable(MAIN_ROUTE){
        MainRoute(finishPage = finishPage)
    }


}


package com.missgem.hwhnhl.ui


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.missgem.hwhnhl.feature.login.LoginRoute
import com.missgem.hwhnhl.feature.main.MAIN_ROUTE
import com.missgem.hwhnhl.feature.main.mainScreen
import com.missgem.hwhnhl.feature.main.navigateToMain

import com.missgem.hwhnhl.feature.splash.splashScreen

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MAIN_ROUTE) {
        splashScreen(
            toMain = {
                navController.navigateToMain()
            }
        )
        mainScreen(finishPage = { navController.popBackStack() })
        composable("login") { LoginRoute(navController) }
    }


//    fun wcLogin() {
//        //发起登陆请求前先注册微信api
//        IWXAPI api = WXAPIFactory.createWXAPI(this,wxb831fa507033254e,true);
//        api.registerApp(“你的微信appid”);
//        if (!api.isWXAppInstalled()){
//            //todo 提醒未安装微信
//            return;
//        }
//        //开始发起登陆请求
//        val SendAuth.Req req = new SendAuth.Req();
//        req.scope = "snsapi_userinfo";
//        req.state = "自定义state";
//        api.sendReq(req);
//    }
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
//    MyApp()
}


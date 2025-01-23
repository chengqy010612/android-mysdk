package com.missgem.hwhnhl.feature.login


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.missgem.hwhnhl.LocalNavController

@Composable
fun LoginRoute(navController: NavHostController) {
    LoginScreen()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {
    val navController = LocalNavController.current
    fun change() {

    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "登录", fontSize = 24.sp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center)
                )
//                OutlinedTextField(
//                    value = null,
//                    onValueChange = { change() },
//                    label = { Text("用户名" )},
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(bottom = 16.dp)
//                )

                Button(onClick = {
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                }) {
                    Text("提交")
                }
            }
        }
    }


}


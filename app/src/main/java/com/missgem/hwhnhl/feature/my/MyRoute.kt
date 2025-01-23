package com.missgem.hwhnhl.feature.my


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clientapp.R
import com.missgem.hwhnhl.LocalNavController

@Composable
fun MyRoute() {
    myScreen()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun myScreen() {
    val navController = LocalNavController.current
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
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp)
                            .background(Color.White, CircleShape)
                            .padding(4.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text ="chengqingyuan",modifier = Modifier.weight(1f).padding(start = 30.dp))
                    Icon(Icons.Filled.Settings, contentDescription = null)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("菜单")

                Column(modifier = Modifier) {
                    Row (modifier = Modifier.height(50.dp),horizontalArrangement = Arrangement.Center) {
                        Icon(Icons.Filled.Person, contentDescription = null)
                        Text(text = "添加好友", modifier = Modifier.weight(1f))
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                    }
                    Row (modifier = Modifier.height(50.dp),horizontalArrangement = Arrangement.Center) {
                        Icon(Icons.Filled.Person, contentDescription = null)
                        Text(text = "添加好友", modifier = Modifier.weight(1f))
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                    }
                    Row (modifier = Modifier.height(50.dp),horizontalArrangement = Arrangement.Center) {
                        Icon(Icons.Filled.Person, contentDescription = null)
                        Text(text = "添加好友", modifier = Modifier.weight(1f))
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                    }
                }

                Button(onClick = {
                    navController.navigate("login")
                },Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center)
               ) {
                    Text("退出登录")
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    myScreen()
}

package com.example.clientapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.clientapp.feature.splash.SplashRoute
import com.example.clientapp.ui.MyApp
import com.example.clientapp.ui.theme.ClientAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))
            val navController = rememberNavController()
            ClientAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                MyApp(navController = navController)
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
    SplashRoute()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClientAppTheme {
        Greeting("Android")
    }
}
package com.example.clientapp.components


import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NavBar() {

//    NavigationBar {
//        items.forEachIndexed { index, item ->
//            NavigationBarItem(
//                icon = {
//                    Icon(
//                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
//                        contentDescription = item
//                    )
//                },
//                label = { Text(item) },
//                selected = selectedItem == index,
//                onClick = { selectedItem = index }
//            )
//        }
//    }
}

@Preview
@Composable
fun NavBarPreview() {
    NavBar()
}


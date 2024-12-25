package com.example.dog_data_app.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dog_data_app.ui.screen.randomdog.RandomDogScreen
import com.example.dog_data_app.ui.theme.Dog_Data_AppTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dog_Data_AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomDogScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Dog_Data_AppTheme {
//        Column(modifier = Modifier.fillMaxSize()) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .weight(1f)
//                    .background(Color.Cyan),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "Ejemplo 1")
//            }
//            Box(modifier = Modifier.weight(1f)) {
//                Row() {
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .fillMaxSize()
//                            .background(Color.Red),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = "Ejemplo 2")
//                    }
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .fillMaxSize()
//                            .background(Color.Green),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = "Ejemplo 3")
//                    }
//                }
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .weight(1f)
//                    .background(Color.Magenta),
//                contentAlignment = Alignment.BottomCenter
//            ) {
//                Text(text = "Ejemplo 4")
//            }
//        }
//    }
//}
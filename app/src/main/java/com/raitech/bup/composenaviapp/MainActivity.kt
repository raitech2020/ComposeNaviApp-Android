package com.raitech.bup.composenaviapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.raitech.bup.composenaviapp.ui.theme.ComposeNaviAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNaviAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(
                            route = Screen.Home.route
                        ) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            route = Screen.Detail.route,
                            arguments = listOf(
                                navArgument(DETAIL_ARGUMENT_KEY1) {
                                    type = NavType.IntType
                                },
                                navArgument(DETAIL_ARGUMENT_KEY2) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            Log.d("MyApp-Detail", it.arguments?.getInt(DETAIL_ARGUMENT_KEY1).toString())
                            Log.d("MyApp-Detail", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
                            DetailScreen(navController = navController)
                        }
                        composable(
                            route = Screen.Bup.route,
                            arguments = listOf(
                                navArgument(BUP_ARGUMENT_ID) {
                                    type = NavType.IntType
                                    defaultValue = 10
                                },
                                navArgument(BUP_ARGUMENT_NAME) {
                                    type = NavType.StringType
                                    defaultValue = "BUP Tech"
                                }
                            )
                        ) {
                            Log.d("MyApp-Bup", it.arguments?.getInt(BUP_ARGUMENT_ID).toString())
                            Log.d("MyApp-Bup", it.arguments?.getString(BUP_ARGUMENT_NAME).toString())
                            BupScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNaviAppTheme {
        Greeting("Android")
    }
}